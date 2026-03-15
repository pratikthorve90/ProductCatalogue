package com.pratik.productcatalogue.services;

import com.pratik.productcatalogue.dtos.GenericProductDto;
import com.pratik.productcatalogue.models.Product;

public interface ProductService {

    GenericProductDto getProductById(long id);
}
