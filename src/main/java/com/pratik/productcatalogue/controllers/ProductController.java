package com.pratik.productcatalogue.controllers;

import com.pratik.productcatalogue.dtos.GenericProductDto;
import com.pratik.productcatalogue.exceptions.ProductNotFoundException;
import com.pratik.productcatalogue.services.facade.ProductCatalogueFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("products")
public class ProductController {


    private final ProductCatalogueFacade productCatalogueFacade;

    public ProductController(ProductCatalogueFacade productCatalogueFacade) {
        this.productCatalogueFacade = productCatalogueFacade;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return this.productCatalogueFacade.getAllProducts();
    }


    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable long id) throws ProductNotFoundException {
        return productCatalogueFacade.getProductById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable long id){
        return new ResponseEntity<>(
                productCatalogueFacade.deleteProductById(id),
                HttpStatus.ACCEPTED
        );
    }

    @PostMapping
    public String createProduct(@RequestBody GenericProductDto genericProductDto){
        GenericProductDto response = productCatalogueFacade.createProduct(genericProductDto);
        return "Successfully Created the Product with ID" + response.getId();
    }

    @PutMapping("{id}")
    public GenericProductDto updateProductById(@PathVariable long id, @RequestBody GenericProductDto genericProductDto){
        return productCatalogueFacade.updateProductById(id,genericProductDto);
    }

}
