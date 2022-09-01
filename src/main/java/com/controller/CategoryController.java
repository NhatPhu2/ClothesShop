package com.controller;



import com.DTO.CategoryDTO;
import com.DTO.ProductDTO;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/all")
    public List<CategoryDTO> getAllCategory() {
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public CategoryDTO getCategorytById(@PathVariable("id") Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping("/category")
    public CategoryDTO createCategory(@RequestBody CategoryDTO category) {
        return categoryService.create(category);
    }

    @PostMapping("/category/{id}")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO category){
        return categoryService.update(category);
    }

    @DeleteMapping("/category")
    public void deleteCategory(@PathVariable("id") List<Integer> id) {
        categoryService.remove(id);
    }
}
