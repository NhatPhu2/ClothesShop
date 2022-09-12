package com.serviceImpl;

import com.DAO.ProductSizesDAO;
import com.DTO.ProductSizesDTO;
import com.entity.ProductSizes;
import com.service.ProductSizesService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSizesServiceImpl implements ProductSizesService {

    @Autowired
    ProductSizesDAO productSizesDAO;

    @Autowired
    Convert convert;

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

    @Override
    public ProductSizesDTO findByIdProductAndIdSize(Integer idProduct, Integer idSize){
        ProductSizes productSizes = productSizesDAO.findByIdProductAndIdSize(idProduct,idSize);
        ProductSizesDTO productSizesDTO = convert.toDto(productSizes,ProductSizesDTO.class);
        return productSizesDTO;
    }

    @Override
    public List<ProductSizesDTO> findByIdProduct(Integer idProduct) {
         List<ProductSizes> productSizes = productSizesDAO.findByIdProduct(idProduct);
         List<ProductSizesDTO> productSizesDTOS = productSizes.stream()
                 .map(productSize -> convert.toDto(productSize,ProductSizesDTO.class))
                 .collect(Collectors.toList());
        return productSizesDTOS;
    }
}
