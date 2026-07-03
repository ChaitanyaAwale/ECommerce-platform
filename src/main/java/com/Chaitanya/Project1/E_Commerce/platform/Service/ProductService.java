package com.Chaitanya.Project1.E_Commerce.platform.Service;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Category;
import com.Chaitanya.Project1.E_Commerce.platform.Entity.Product;
import com.Chaitanya.Project1.E_Commerce.platform.dto.ProductRequestDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.ProductResponseDto;
import com.Chaitanya.Project1.E_Commerce.platform.exceptions.ResourceNotFoundException;
import com.Chaitanya.Project1.E_Commerce.platform.repository.CategoryRepository;
import com.Chaitanya.Project1.E_Commerce.platform.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public  ProductResponseDto getProductById(Long id) {
        Product product =productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        ProductResponseDto dto=modelMapper.map(product, ProductResponseDto.class);
        return dto;
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Category category=categoryRepository.findById(productRequestDto.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("No category exists"));

        Product product=modelMapper.map(productRequestDto,Product.class);
        product.setCategory(category);
        Product SavedProduct=productRepository.save(product);

        ProductResponseDto dto=modelMapper.map(SavedProduct, ProductResponseDto.class);
        return dto;
    }

    public List<ProductResponseDto> getAllProducts() {


        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductResponseDto.class))
                .toList();
    }

    public ProductResponseDto UpdateProduct(Long id, ProductRequestDto Dto) {
        Product product=productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("product not found"));

        Category category=categoryRepository.findById(Dto.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("Category not found"));

        product.setName(Dto.getName());
        product.setPrice(Dto.getPrice());
        product.setDescription(Dto.getDescription());
        product.setStockQuantity(Dto.getStockQuantity());
        product.setImageUrl(Dto.getImageUrl());
        product.setCategory(category);
        Product updateProduct=productRepository.save(product);
        ProductResponseDto dto1=modelMapper.map(updateProduct, ProductResponseDto.class);
        return dto1;
    }

    public void DeleteProduct(Long id) {
        Product product =productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("NO product found"));
        productRepository.delete(product);
    }
}
