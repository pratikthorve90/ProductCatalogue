package com.pratik.productcatalogue.services;

import com.pratik.productcatalogue.dtos.GenericProductDto;
import com.pratik.productcatalogue.exceptions.ProductNotFoundException;
import com.pratik.productcatalogue.thirdpartyclients.ThirdPartyProductService;
import com.pratik.productcatalogue.thirdpartyclients.fakestore.FakeStoreProductDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class FakeStoreProductService implements ProductService {

    private final ThirdPartyProductService thirdPartyProductService;

    public FakeStoreProductService(ThirdPartyProductService thirdPartyProductService) {
        this.thirdPartyProductService = thirdPartyProductService;
    }

    private GenericProductDto convertToGenericProductDTO(FakeStoreProductDTO fakeStoreProductDTO) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDTO.getId());
        genericProductDto.setImage(fakeStoreProductDTO.getImage());
        genericProductDto.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDto.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDto.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDto.setCategory(fakeStoreProductDTO.getCategory());
        return genericProductDto;
    }

    private FakeStoreProductDTO convertToFakeStoreProductDTO(GenericProductDto genericProductDto) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(genericProductDto.getId());
        fakeStoreProductDTO.setImage(genericProductDto.getImage());
        fakeStoreProductDTO.setPrice(genericProductDto.getPrice());
        fakeStoreProductDTO.setTitle(genericProductDto.getTitle());
        fakeStoreProductDTO.setDescription(genericProductDto.getDescription());
        fakeStoreProductDTO.setCategory(genericProductDto.getCategory());
        return fakeStoreProductDTO;
    }

    public GenericProductDto getProductById(long id) throws ProductNotFoundException {
            return convertToGenericProductDTO(thirdPartyProductService.getProductById(id));
    }

    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        FakeStoreProductDTO  fakeStoreProductDTO = convertToFakeStoreProductDTO(genericProductDto);
        return convertToGenericProductDTO(thirdPartyProductService.createProduct(fakeStoreProductDTO));
    }

    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        List<FakeStoreProductDTO> fakeStoreProductDTOList = thirdPartyProductService.getAllProducts();
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList) {
            genericProductDtoList.add(convertToGenericProductDTO(fakeStoreProductDTO));
        }
        return genericProductDtoList;
    }

    public GenericProductDto deleteProductById(long id){
         return convertToGenericProductDTO(thirdPartyProductService.deleteProductById(id));
    }

    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto)    {
        FakeStoreProductDTO  fakeStoreProductDTO = convertToFakeStoreProductDTO(genericProductDto);
        return convertToGenericProductDTO(thirdPartyProductService.updateProductById(id,fakeStoreProductDTO));
    }

}
