package com.example.productservice.services;

import com.example.productservice.dtos.GeneralResponseDto;

import java.util.List;


public interface ProductServices {

    public GeneralResponseDto getProductById(Long id);
    public List<GeneralResponseDto> getAllProducts();
    public GeneralResponseDto createProduct(GeneralResponseDto generalRequestDto);

    public void deleteProductById(Long id);
}
