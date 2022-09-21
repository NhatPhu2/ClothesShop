package com.service;

import com.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(Integer id);
    ProductDTO create(ProductDTO ProductDto);
    ProductDTO update(ProductDTO ProductDto);
    void remove(List<Integer> id);
    List<ProductDTO> findAllByIdCategory(Integer idCategory);
    List<ProductDTO> page(int size, int page);


    List<ProductDTO> fillByIdCategoryAndIdStyle(Integer idCategory, Integer idProductStyle);
}
