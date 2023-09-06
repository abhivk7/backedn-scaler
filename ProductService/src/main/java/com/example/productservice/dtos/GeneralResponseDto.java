package com.example.productservice.dtos;

import com.example.productservice.models.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralResponseDto {

    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
