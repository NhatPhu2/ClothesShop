package com.service;

import com.DTO.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(Integer id);
    void create(CategoryDto CategoryDto);
    void update(CategoryDto CategoryDto);
    void remove(Integer id);
}
