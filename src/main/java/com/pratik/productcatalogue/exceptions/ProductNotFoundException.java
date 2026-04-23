package com.pratik.productcatalogue.exceptions;

public class ProductNotFoundException extends  Exception {

    public ProductNotFoundException(long id) {
        super("Product not found with id " + id);
    }
}
