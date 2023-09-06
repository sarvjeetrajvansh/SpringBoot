package com.sarvjeet.productcatalogservice.services;

import com.sarvjeet.productcatalogservice.dtos.GenericProductDto;

public interface ProductService {

  GenericProductDto createProduct(GenericProductDto product);

  GenericProductDto getProductById(Long id);

}
