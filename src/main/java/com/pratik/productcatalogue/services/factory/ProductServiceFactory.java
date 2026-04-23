package com.pratik.productcatalogue.services.factory;

import com.pratik.productcatalogue.services.FakeStoreProductService;
import com.pratik.productcatalogue.services.FlipkartProductService;
import com.pratik.productcatalogue.services.ProductService;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class ProductServiceFactory {

    private static final int RANDOM_DRAW_INCLUSIVE_MIN = 1;
    private static final int RANDOM_DRAW_EXCLUSIVE_MAX = 101;

    private final FakeStoreProductService fakeStoreProductService;
    private final FlipkartProductService flipkartProductService;

    public ProductServiceFactory(
            FakeStoreProductService fakeStoreProductService,
            FlipkartProductService flipkartProductService) {
        this.fakeStoreProductService = fakeStoreProductService;
        this.flipkartProductService = flipkartProductService;
    }

    public ProductService getProductService() {
        int randomDrawOneToOneHundred = ThreadLocalRandom.current()
                .nextInt(RANDOM_DRAW_INCLUSIVE_MIN, RANDOM_DRAW_EXCLUSIVE_MAX);
        if (randomDrawOneToOneHundred % 2 == 0) {
            return fakeStoreProductService;
        }
        return flipkartProductService;
    }
}
