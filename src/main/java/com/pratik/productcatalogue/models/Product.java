package com.pratik.productcatalogue.models;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor  // Created a constructor will all Arguments
@NoArgsConstructor // Create constructor with no arguments
@Data  // Combination of Getter and Setter
@Builder // Will create a public static inner Builder class : Builder Design pattern
public class Product extends BaseModel {

    private String title;

    private String description;

    private String imageUrl;

    private Category category;

    private double price;


}
