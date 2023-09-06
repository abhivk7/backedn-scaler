package com.example.productservice.Controller;

import com.example.productservice.dtos.GeneralResponseDto;
import com.example.productservice.services.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductServices productServices;

    public ProductController(ProductServices productServices) {

        this.productServices = productServices;
    }

    @GetMapping("{id}")
    public GeneralResponseDto getProductById(@PathVariable("id") Long id) {
        System.out.println("Inside getProductById method");
        return productServices.getProductById(id);
    }
    @GetMapping
    public List<GeneralResponseDto> getAllProducts() {

        return productServices.getAllProducts();
    }

    // localhost:8080/products/{id}
    // localhost:8080/products/123


    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") Long id) {

         productServices.deleteProductById(id);

    }

    @PostMapping
    public GeneralResponseDto createProduct(@RequestBody GeneralResponseDto generalRequestDto) {
//        System.out.println(product.name);

        return productServices.createProduct(generalRequestDto);
    }

    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id") Long id) {



    }


}
