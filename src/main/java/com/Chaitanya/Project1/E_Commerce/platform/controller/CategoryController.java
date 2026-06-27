package com.Chaitanya.Project1.E_Commerce.platform.controller;


import com.Chaitanya.Project1.E_Commerce.platform.Service.CategoryService;
import com.Chaitanya.Project1.E_Commerce.platform.dto.CategoryRequestDto;
import com.Chaitanya.Project1.E_Commerce.platform.dto.CategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto dto)
    {
        return categoryService.createCategory(dto);
    }
    @GetMapping
    public List<CategoryResponseDto> getAllCategories()
    {
        return categoryService.getAllCategories();

    }
    @GetMapping("/id")
    public CategoryResponseDto getCategoryById(@PathVariable Long id)
    {
        return categoryService.getCategoryById(id);
    }
    @PutMapping("/id")
    public CategoryResponseDto updateCategory(@PathVariable Long id,@RequestBody CategoryRequestDto dto)
    {
        return categoryService.updateCategory(id,dto);
    }
    @DeleteMapping("/id")
    public void deleteCategory(@PathVariable Long id)
    {
         categoryService.deleteCategory(id);
  }



}
