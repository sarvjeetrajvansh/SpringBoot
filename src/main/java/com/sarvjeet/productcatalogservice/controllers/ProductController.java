package com.sarvjeet.productcatalogservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarvjeet.productcatalogservice.dtos.GenericProductDto;
import com.sarvjeet.productcatalogservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
  private ProductService productService;

  public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public void getAllProducts() {
  }

  @GetMapping("{id}")
  public GenericProductDto getProductById(@PathVariable("id") Long id) {
    return productService.getProductById(id);
  }

  @DeleteMapping("{id}")
  public void deleteProductById(@PathVariable("id") Long id) {
  }

  @PutMapping("{id}")
  public void updateProductById(@PathVariable("id") Long id) {

  }

  @PostMapping
  public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
    return productService.createProduct(product);
  }
}
