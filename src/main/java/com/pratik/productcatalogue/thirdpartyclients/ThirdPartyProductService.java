package com.pratik.productcatalogue.thirdpartyclients;

import com.pratik.productcatalogue.thirdpartyclients.fakestore.FakeStoreProductDTO;
import com.pratik.productcatalogue.exceptions.ProductNotFoundException;

import java.util.List;

public interface ThirdPartyProductService {

    FakeStoreProductDTO getProductById(long id);

    FakeStoreProductDTO createProduct(FakeStoreProductDTO fakeStoreProductDTO);

    List<FakeStoreProductDTO> getAllProducts();

    FakeStoreProductDTO deleteProductById(long id);

    FakeStoreProductDTO updateProductById(Long Id, FakeStoreProductDTO fakeStoreProductDTO);




}
