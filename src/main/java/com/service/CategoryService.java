package com.service;

import com.DTO.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAll();
    CategoryDTO findById(Integer id);
    CategoryDTO create(CategoryDTO CategoryDto);
    CategoryDTO update(CategoryDTO CategoryDto);
    void remove(List<Integer> id);
}