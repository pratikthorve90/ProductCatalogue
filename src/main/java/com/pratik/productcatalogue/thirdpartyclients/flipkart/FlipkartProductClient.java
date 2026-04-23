package com.pratik.productcatalogue.thirdpartyclients.flipkart;

import com.pratik.productcatalogue.thirdpartyclients.ThirdPartyProductService;
import com.pratik.productcatalogue.thirdpartyclients.fakestore.FakeStoreProductDTO;

import java.util.List;

public class FlipkartProductClient implements ThirdPartyProductService {
    @Override
    public FakeStoreProductDTO getProductById(long id) {
        return null;
    }

    @Override
    public FakeStoreProductDTO createProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        return null;
    }

    @Override
    public List<FakeStoreProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public FakeStoreProductDTO deleteProductById(long id) {
        return null;
    }

    @Override
    public FakeStoreProductDTO updateProductById(Long Id, FakeStoreProductDTO fakeStoreProductDTO) {
        return null;
    }
}
