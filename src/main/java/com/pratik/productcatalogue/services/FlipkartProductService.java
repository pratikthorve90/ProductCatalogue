package com.pratik.productcatalogue.services;

import com.pratik.productcatalogue.dtos.GenericProductDto;
import com.pratik.productcatalogue.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlipkartProductService implements ProductService {
    @Override
    public GenericProductDto getProductById(long id) throws ProductNotFoundException {
        throw new ProductNotFoundException(id);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public GenericProductDto deleteProductById(long id) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long Id, GenericProductDto genericProductDto) {
        return null;
    }
}
