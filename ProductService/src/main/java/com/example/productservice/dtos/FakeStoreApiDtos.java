package com.example.productservice.dtos;

import lombok.Data;

@Data
public class FakeStoreApiDtos {

    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
