package com.serviceImpl;

import com.DAO.ProductColorsDAO;
import com.DTO.ProductColorsDTO;
import com.entity.ProductColors;
import com.service.ProductColorsService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductColorsServiceImpl implements ProductColorsService {

    @Autowired
    ProductColorsDAO productColorsDAO;
    @Autowired
    Convert convert;

    @Override
    public List<ProductColorsDTO> findAll() {
        List<ProductColors> productColor = productColorsDAO.findAll();
        List<ProductColorsDTO> productColorsDTOS = productColor.stream()
                .map(product -> convert.toDto(product, ProductColorsDTO.class))
                .collect(Collectors.toList());
        return productColorsDTOS;
    }

    @Override
    public ProductColorsDTO findById(Integer id) {
        return null;
    }

    @Override
    public ProductColorsDTO findByIdColorAndIdProduct(Integer idColor, Integer idProduct) {
        ProductColors productColors = productColorsDAO.findByIdColorAndIdProduct(idColor,idProduct);
        ProductColorsDTO productColorsDTO = convert.toDto(productColors, ProductColorsDTO.class);
        return productColorsDTO;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public ProductColorsDTO create(ProductColorsDTO productColorsDto) {
        ProductColors productColors = convert.toEntity(productColorsDto,ProductColors.class);
        ProductColorsDTO productColorsDTO = convert.toDto(productColorsDAO.save(productColors),ProductColorsDTO.class);
        return productColorsDTO;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public ProductColorsDTO update(ProductColorsDTO productColorsDto) {
        ProductColors productColors = convert.toEntity(productColorsDto,ProductColors.class);
        ProductColorsDTO productColorsDTO = convert.toDto(productColorsDAO.save(productColors),ProductColorsDTO.class);
        return productColorsDTO;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void remove(Integer id) {
        productColorsDAO.deleteById(id);
    }
    @Override
    public List<ProductColorsDTO> findByIdColor(Integer idColor){
        List<ProductColors> productColors = productColorsDAO.findByIdColor(idColor);
        List<ProductColorsDTO> productColorsDTOS = productColors.stream()
                .map(productColor -> convert.toDto(productColor,ProductColorsDTO.class))
                .collect(Collectors.toList());
        return  productColorsDTOS;
    }

    @Override
    public List<ProductColorsDTO> findByIdProduct(Integer idProduct) {
        List<ProductColors> productColors = productColorsDAO.findByIdProduct(idProduct);
        List<ProductColorsDTO> productColorsDTOS = productColors.stream()
                .map(productColor -> convert.toDto(productColor,ProductColorsDTO.class))
                .collect(Collectors.toList());
        return productColorsDTOS;
    }
}
