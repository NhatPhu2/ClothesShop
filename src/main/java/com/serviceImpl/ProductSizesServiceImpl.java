package com.serviceImpl;

import com.DTO.ProductSizesDTO;
import com.service.ProductSizesService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductSizesServiceImpl implements ProductSizesService {
    @Override
    public List<ProductSizesDTO> findAll() {
        return null;
    }

    @Override
    public ProductSizesDTO findById(Integer id) {
        return null;
    }

    @Override
    public void create(ProductSizesDTO ProductSizesDto) {

    }

    @Override
    public void update(ProductSizesDTO ProductSizesDto) {

    }

    @Override
    public void remove(Integer id) {

    }
}
