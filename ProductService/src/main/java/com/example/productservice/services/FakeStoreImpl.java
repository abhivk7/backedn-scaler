package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreApiDtos;
import com.example.productservice.dtos.GeneralResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("fakeStoreProductService")
public class FakeStoreImpl implements ProductServices {

    RestTemplateBuilder restTemplateBuilder;

    private final String requestUrlForProduct =  "https://fakestoreapi.com/products/{id}";

    private final String requestUrlForDeeleteProduct =  "https://fakestoreapi.com/products/{id}";
    private final String requestUrlForAllProduct =  "https://fakestoreapi.com/products/";

    private final String requestUrlForCreatingProduct =  "https://fakestoreapi.com/products/";

    public FakeStoreImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public GeneralResponseDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDtos> responseFromFakeApi  = restTemplate.getForEntity(requestUrlForProduct,FakeStoreApiDtos.class,id);
        FakeStoreApiDtos fakeStoreApiDtosData = responseFromFakeApi.getBody();

        return GeneralResponseDto.builder().id(fakeStoreApiDtosData.getId()).title(fakeStoreApiDtosData.getTitle())
                .description(fakeStoreApiDtosData.getDescription()).image(fakeStoreApiDtosData.getImage()).category(fakeStoreApiDtosData.getCategory()).build();

    }

    @Override
    public List<GeneralResponseDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreApiDtos[]> listResponseEntity= restTemplate.getForEntity(requestUrlForAllProduct,FakeStoreApiDtos[].class);
        List<GeneralResponseDto> listOfResponse = new ArrayList<>();
        for(FakeStoreApiDtos fakeStoreApiDtosData : Objects.requireNonNull(listResponseEntity.getBody())){
            listOfResponse.add(GeneralResponseDto.builder().id(fakeStoreApiDtosData.getId()).title(fakeStoreApiDtosData.getTitle())
                    .description(fakeStoreApiDtosData.getDescription()).image(fakeStoreApiDtosData.getImage()).category(fakeStoreApiDtosData.getCategory()).build());
        }
        return listOfResponse;
    }

    @Override
    public GeneralResponseDto createProduct(GeneralResponseDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GeneralResponseDto> responseForCreate = restTemplate.postForEntity(requestUrlForCreatingProduct,product,GeneralResponseDto.class);
        return responseForCreate.getBody();
    }

    @Override
    public void deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(requestUrlForDeeleteProduct,id);
    }
}
