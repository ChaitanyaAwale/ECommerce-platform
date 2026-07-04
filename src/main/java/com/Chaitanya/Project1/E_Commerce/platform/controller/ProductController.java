package com.Chaitanya.Project1.E_Commerce.platform.controller;

import com.Chaitanya.Project1.E_Commerce.platform.Service.ProductService;
import com.Chaitanya.Project1.E_Commerce.platform.dto.PageResponseDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.ProductRequestDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.ProductResponseDto;
import jakarta.validation.Valid;
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
    public ProductResponseDto createProduct(@Valid @RequestBody ProductRequestDto productRequestDto)
    {
        return productService.createProduct(productRequestDto);
    }
    @GetMapping
    public PageResponseDto<ProductResponseDto> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction)
    {
        return productService.getAllProducts(page,size,sortBy,direction);
    }

    @GetMapping("/{id}")
    public  ProductResponseDto getProductById(@PathVariable Long id)
    {
        return productService.getProductById(id);
    }
    @PutMapping("/{id}")
    public ProductResponseDto UpdateProduct(@PathVariable Long id,@Valid @RequestBody ProductRequestDto productRequestDto)
    {
       return  productService.UpdateProduct(id,productRequestDto);
    }

    @DeleteMapping("/{id}")
    public void DeleteProduct(@PathVariable Long id)
    {
        productService.DeleteProduct(id);
    }

}
