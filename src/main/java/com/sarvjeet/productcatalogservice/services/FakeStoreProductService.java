package com.sarvjeet.productcatalogservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.sarvjeet.productcatalogservice.dtos.FakeStoreProductDto;
import com.sarvjeet.productcatalogservice.dtos.GenericProductDto;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

  private RestTemplateBuilder restTemplateBuilder;
  private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
  private String createProductRequestUrl = "https://fakestoreapi.com/products";
  private String productRequestsBaseUrl = "https://fakestoreapi.com/products";

  public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplateBuilder = restTemplateBuilder;
  }

  private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {

    GenericProductDto product = new GenericProductDto();
    product.setId(fakeStoreProductDto.getId());
    product.setImage(fakeStoreProductDto.getImage());
    product.setDescription(fakeStoreProductDto.getDescription());
    product.setTitle(fakeStoreProductDto.getTitle());
    product.setPrice(fakeStoreProductDto.getPrice());
    product.setCategory(fakeStoreProductDto.getCategory());

    return product;
  }

  @Override
  public GenericProductDto getProductById(Long id) {
    RestTemplate restTemplate = restTemplateBuilder.build();

    ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestUrl,
        FakeStoreProductDto.class, id);

    FakeStoreProductDto fakeStoreProductDto = response.getBody();

    return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);

  }

  @Override
  public GenericProductDto createProduct(GenericProductDto product) {

    RestTemplate restTemplate = restTemplateBuilder.build();

    ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestUrl, product,
        GenericProductDto.class);

    return response.getBody();

  }

  @Override
  public List<GenericProductDto> getAllProducts() {
    RestTemplate restTemplate = restTemplateBuilder.build();

    ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestsBaseUrl,
        FakeStoreProductDto[].class);

    List<GenericProductDto> answer = new ArrayList<>();

    for (FakeStoreProductDto fakeStoreProductDto : response.getBody()) {

      answer.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
    }

    return answer;
  }

  @Override
  public GenericProductDto deleteProduct(Long id) {
    RestTemplate restTemplate = restTemplateBuilder.build();

    RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
    ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate
        .responseEntityExtractor(FakeStoreProductDto.class);
    ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(getProductRequestUrl, HttpMethod.DELETE,
        requestCallback, responseExtractor, id);

    FakeStoreProductDto fakeStoreProductDto = response.getBody();

    return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
  }

  @Override
  public GenericProductDto updateProduct(Long id, GenericProductDto product) {
    RestTemplate restTemplate = restTemplateBuilder.build();
    RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
    ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate
        .responseEntityExtractor(FakeStoreProductDto.class);
    ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(getProductRequestUrl, HttpMethod.PUT,
        requestCallback, responseExtractor, id, product);

    FakeStoreProductDto fakeStoreProductDto = response.getBody();

    return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);

  }
}
