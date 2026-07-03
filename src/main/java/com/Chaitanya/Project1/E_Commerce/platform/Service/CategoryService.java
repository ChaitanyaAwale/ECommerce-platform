package com.Chaitanya.Project1.E_Commerce.platform.Service;

import com.Chaitanya.Project1.E_Commerce.platform.Entity.Category;
import com.Chaitanya.Project1.E_Commerce.platform.dto.CategoryRequestDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.CategoryResponseDto;
import com.Chaitanya.Project1.E_Commerce.platform.exceptions.ResourceNotFoundException;
import com.Chaitanya.Project1.E_Commerce.platform.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    public CategoryResponseDto createCategory(CategoryRequestDto dto) {
        Category category=modelMapper.map(dto,Category.class);
        Category savedCategory=categoryRepository.save(category);
        CategoryResponseDto dto1=modelMapper.map(savedCategory,CategoryResponseDto.class);
        return dto1;

    }

    public List<CategoryResponseDto> getAllCategories() {

        List<Category> categories=categoryRepository.findAll();

        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryResponseDto.class))
                .toList();
    }
    public CategoryResponseDto getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return modelMapper.map(category, CategoryResponseDto.class);
    }

    // Update Category
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto dto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(dto.getName());

        Category updatedCategory = categoryRepository.save(category);

        return modelMapper.map(updatedCategory, CategoryResponseDto.class);
    }

    // Delete Category
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        categoryRepository.delete(category);
    }
}

