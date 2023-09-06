package com.sarvjeet.productcatalogservice.services;

import java.util.List;

import com.sarvjeet.productcatalogservice.dtos.GenericProductDto;

public interface ProductService {

  GenericProductDto createProduct(GenericProductDto product);

  GenericProductDto getProductById(Long id);

  List<GenericProductDto> getAllProducts();

  GenericProductDto deleteProduct(Long id);

  GenericProductDto updateProduct(Long id, GenericProductDto product);

}
