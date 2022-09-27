package com.service;

import com.DTO.ColorDTO;
import com.DTO.ProductColorsDTO;
import com.entity.Color;

import java.util.List;

public interface ProductColorsService {
    List<ProductColorsDTO> findAll();
    ProductColorsDTO findById(Integer id);

    ProductColorsDTO findByIdColorAndIdProduct(Integer idColor, Integer idProduct);

    ProductColorsDTO create(ProductColorsDTO ProductColorsDto);
    ProductColorsDTO update(ProductColorsDTO ProductColorsDto);
    void remove(Integer id);

    List<ColorDTO> findByIdProduct(Integer idProduct);

    List<ProductColorsDTO> findByColor(Integer idColor);

    List<ProductColorsDTO> fillBySize(Integer idSize);
}
