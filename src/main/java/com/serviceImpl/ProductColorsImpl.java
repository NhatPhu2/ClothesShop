package com.serviceImpl;

import com.DAO.ProductColorsDAO;
import com.DTO.ProductColorsDTO;
import com.entity.ProductColors;
import com.service.ProductColorsService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductColorsImpl implements ProductColorsService {

    @Autowired
    ProductColorsDAO productColorsDAO;
    @Autowired
    Convert convert;

    @Override
    public List<ProductColorsDTO> findAll() {
        List<ProductColors> productColor = productColorsDAO.findAll();
        List<ProductColorsDTO> productColorsDTOS = productColor.stream()
                .map(product -> convert.toDto(productColor,ProductColorsDTO.class))
                .collect(Collectors.toList());
        return productColorsDTOS ;
    }

    @Override
    public ProductColorsDTO findById(Integer id) {
        return null;
    }

    @Override
    public void create(ProductColorsDTO ProductColorsDto) {

    }

    @Override
    public void update(ProductColorsDTO ProductColorsDto) {

    }

    @Override
    public void remove(Integer id) {

    }
}
