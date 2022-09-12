package com.service;

import com.DTO.ProductSizesDTO;

import java.util.List;

public interface ProductSizesService {
    List<ProductSizesDTO> findAll();
    ProductSizesDTO findById(Integer id);
    void create(ProductSizesDTO ProductSizesDto);
    void update(ProductSizesDTO ProductSizesDto);
    void remove(Integer id);

    ProductSizesDTO findByIdProductAndIdSize(Integer idProduct, Integer idSize);
    List<ProductSizesDTO> findByIdProduct(Integer idProduct);
}
