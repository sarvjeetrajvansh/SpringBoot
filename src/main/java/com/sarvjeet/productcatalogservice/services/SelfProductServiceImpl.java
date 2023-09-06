package com.sarvjeet.productcatalogservice.services;

import java.util.List;

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

  @Override
  public List<GenericProductDto> getAllProducts() {
    return null;
  }

  @Override
  public GenericProductDto deleteProduct(Long id) {
    return null;
  }

  @Override
  public GenericProductDto updateProduct(Long id, GenericProductDto product) {
    return null;
  }
}
