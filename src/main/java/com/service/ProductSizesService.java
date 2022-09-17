package com.service;

import com.DTO.ProductDTO;
import com.DTO.ProductSizesDTO;
import com.entity.Product;

import java.util.List;

public interface ProductSizesService {
    List<ProductSizesDTO> findAll();
    ProductSizesDTO findById(Integer id);
    ProductSizesDTO create(ProductSizesDTO ProductSizesDto);
    ProductSizesDTO update(ProductSizesDTO ProductSizesDto);
    void remove(Integer id);

    ProductSizesDTO findByIdProductColorsAndIdSize(Integer idSize, Integer idProductColor);

//    ProductSizesDTO findByIdProductAndIdSize(Integer idProduct, Integer idSize);
//
//    List<ProductDTO> findByIdSize(Integer idSize);
//
//    List<ProductSizesDTO> findByIdProduct(Integer idProduct);
}
