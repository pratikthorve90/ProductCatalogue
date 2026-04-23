package com.pratik.productcatalogue.thirdpartyclients.fakestore;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class FakeStoreProductDTO {

    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;


}
