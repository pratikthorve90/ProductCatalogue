package com.pratik.productcatalogue.exceptions;

public class ProductNotFoundException extends Exception {

    private final long productId;

    public ProductNotFoundException(long productId) {
        super("Product not found with id " + productId);
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }
}
