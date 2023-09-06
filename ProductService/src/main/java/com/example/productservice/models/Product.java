package com.example.productservice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Product extends BaseModal{

    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;
}
