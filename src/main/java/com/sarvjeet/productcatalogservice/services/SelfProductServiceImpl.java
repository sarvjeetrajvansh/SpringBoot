package com.sarvjeet.productcatalogservice.services;

import org.springframework.stereotype.Service;

import com.sarvjeet.productcatalogservice.dtos.GenericProductDto;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

  @Override
  public GenericProductDto getProductById(Long id) {
    return null;
  }

  @Override
  public GenericProductDto createProduct(GenericProductDto product) {
    return null;

  }

}
