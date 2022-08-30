package com.service;

import com.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAll();
    CategoryDTO findById(Integer id);
    void create(CategoryDTO CategoryDto);
    void update(CategoryDTO CategoryDto);
    void remove(Integer id);
}
