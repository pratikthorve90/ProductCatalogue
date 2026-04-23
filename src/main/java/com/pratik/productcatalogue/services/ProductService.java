package com.pratik.productcatalogue.services;

import com.pratik.productcatalogue.dtos.GenericProductDto;
import com.pratik.productcatalogue.exceptions.ProductNotFoundException;
import com.pratik.productcatalogue.models.Product;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(long id) throws ProductNotFoundException;

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(long id);

    GenericProductDto updateProductById(Long Id, GenericProductDto genericProductDto);


}
