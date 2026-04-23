package com.pratik.productcatalogue.services.facade;

import com.pratik.productcatalogue.dtos.GenericProductDto;
import com.pratik.productcatalogue.exceptions.ProductNotFoundException;
import com.pratik.productcatalogue.services.factory.ProductServiceFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCatalogueFacade {

    private final ProductServiceFactory productServiceFactory;

    public ProductCatalogueFacade(ProductServiceFactory productServiceFactory) {
        this.productServiceFactory = productServiceFactory;
    }

    public List<GenericProductDto> getAllProducts() {
        return productServiceFactory.getProductService().getAllProducts();
    }

    public GenericProductDto getProductById(long id) throws ProductNotFoundException {
        return productServiceFactory.getProductService().getProductById(id);
    }

    public GenericProductDto deleteProductById(long id) {
        return productServiceFactory.getProductService().deleteProductById(id);
    }

    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return productServiceFactory.getProductService().createProduct(genericProductDto);
    }

    public GenericProductDto updateProductById(long id, GenericProductDto genericProductDto) {
        return productServiceFactory.getProductService().updateProductById(id, genericProductDto);
    }
}
