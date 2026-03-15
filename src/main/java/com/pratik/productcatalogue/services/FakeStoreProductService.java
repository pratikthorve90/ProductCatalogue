package com.pratik.productcatalogue.services;

import com.pratik.productcatalogue.dtos.FakeStoreProductDTO;
import com.pratik.productcatalogue.dtos.GenericProductDto;
import com.pratik.productcatalogue.models.Product;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


@Service
public class FakeStoreProductService implements ProductService {

    private final RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreApiUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    

    public GenericProductDto getProductById(long id) {

    RestTemplate restTemplate = restTemplateBuilder.build();
    String url = fakeStoreApiUrl + "/" + id;
    ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(url, FakeStoreProductDTO.class);
    FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
    GenericProductDto product = new GenericProductDto();
    product.setId(fakeStoreProductDTO.getId());
    product.setImage(fakeStoreProductDTO.getImage());
    product.setTitle(fakeStoreProductDTO.getTitle());
    product.setPrice(fakeStoreProductDTO.getPrice());
    product.setDescription(fakeStoreProductDTO.getDescription());
    product.setCategory(fakeStoreProductDTO.getCategory());
    return product;

    }
}
