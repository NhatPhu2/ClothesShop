package com.serviceImpl;

import com.DAO.CategoryDAO;
import com.DTO.CategoryDTO;
import com.DTO.ProductStyleDTO;
import com.entity.Category;
import com.google.gson.reflect.TypeToken;
import com.service.CategoryService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    Convert convert;
    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public List<CategoryDTO> findAll() {
        List<Category> listProduct = categoryDAO.findAll();
        List<CategoryDTO> listCategoryDTO = listProduct.stream().

                map(category -> convert.toDto(category,CategoryDTO.class))
                .collect(Collectors.toList());
        return listCategoryDTO;
    }



    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public CategoryDTO findById(Integer id) {
        Category category = categoryDAO.findById(id).get();
        CategoryDTO categoryDTO = convert.toDto(category, CategoryDTO.class);
        return categoryDTO;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public CategoryDTO create(CategoryDTO CategoryDto) {
        Category newCategory = convert.toEntity(CategoryDto, Category.class);
        CategoryDTO categoryDTO = convert.toDto(categoryDAO.save(newCategory), CategoryDTO.class);
        return categoryDTO;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public CategoryDTO update(CategoryDTO CategoryDto) {
        Category newCategory = convert.toEntity(CategoryDto, Category.class);
        CategoryDTO categoryDTO = convert.toDto(newCategory, CategoryDTO.class);
        return categoryDTO;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void remove(List<Integer> id) {
        categoryDAO.deleteAllById(id);
    }
}
