package com.pratik.productcatalogue.thirdpartyclients.fakestore;


import com.pratik.productcatalogue.thirdpartyclients.ThirdPartyProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductClient implements ThirdPartyProductService {

    private final RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.uri}")
    private String fakeStoreApiUrl;

    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDTO getProductById(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = fakeStoreApiUrl + "/" + id;
        try {
            ResponseEntity<FakeStoreProductDTO> response =
                    restTemplate.getForEntity(url, FakeStoreProductDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            if (HttpStatus.NOT_FOUND.equals(ex.getStatusCode())) {
                return null;
            }
            throw ex;
        }
    }

    public FakeStoreProductDTO createProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(fakeStoreApiUrl, fakeStoreProductDTO, FakeStoreProductDTO.class);
        return response.getBody();
    }

    public List<FakeStoreProductDTO> getAllProducts() {
        List <FakeStoreProductDTO> products = new ArrayList<>();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(fakeStoreApiUrl,FakeStoreProductDTO[].class);
        FakeStoreProductDTO[] responseArray = response.getBody();
        return List.of(responseArray);
    }

    public FakeStoreProductDTO deleteProductById(long id){

        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = fakeStoreApiUrl + "/" + id;

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);

        ResponseEntity<FakeStoreProductDTO> response =  restTemplate.execute(url, HttpMethod.DELETE,requestCallback,responseExtractor);
        return  response.getBody();
    }

    public FakeStoreProductDTO updateProductById(Long Id, FakeStoreProductDTO genericProductDto)
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = fakeStoreApiUrl + "/" + Id;
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(url, FakeStoreProductDTO.class);
        return response.getBody();
    }
}
