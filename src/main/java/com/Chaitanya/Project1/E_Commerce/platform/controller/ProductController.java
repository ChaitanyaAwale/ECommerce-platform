package com.Chaitanya.Project1.E_Commerce.platform.controller;

import com.Chaitanya.Project1.E_Commerce.platform.Service.ProductService;
import com.Chaitanya.Project1.E_Commerce.platform.dto.ProductRequestDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto)
    {
        return productService.createProduct(productRequestDto);
    }
    @GetMapping
    public List<ProductResponseDto> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public  ProductResponseDto getProductById(@PathVariable Long Id)
    {
        return ProductService.getProductById(Id);
    }
    @PutMapping("/{id}")
    public void UpdateProduct(@PathVariable Long id,@RequestBody ProductRequestDto productRequestDto)
    {
        productService.UpdateProduct(id,productRequestDto);
    }

    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable Long id)
    {
        productService.DeleteProduct(id);
    }

}
