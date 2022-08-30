package com.serviceImpl;

import com.DAO.ProductDAO;
import com.DTO.ProductDto;
import com.entity.Product;
import com.service.ProductService;
import com.utils.Convert;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    Convert convert;

    @Override
    public List<ProductDto> findAll() {
        List<Product> listProduct = productDAO.findAll();
        List<ProductDto> listProductDTO = listProduct.stream().
                map(product -> convert.toDto(product,ProductDto.class))
                .collect(Collectors.toList());
        return listProductDTO;

    }

    @Override
    public ProductDto findById(Integer id) {
        Product product = productDAO.findById(id).get();
        return convert.toDto(product, ProductDto.class);
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public ProductDto create(ProductDto ProductDto) {
        Product newProduct = convert.toEntity(ProductDto, Product.class);
        ProductDto productDto = convert.toDto(productDAO.save(newProduct),ProductDto.class);
        return productDto;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public ProductDto update(ProductDto ProductDto) {
        Product newProduct = convert.toEntity(ProductDto,Product.class);
        ProductDto productDto = convert.toDto(productDAO.save(newProduct),ProductDto.class);
        return productDto;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void remove(List<Integer> id) {
        productDAO.deleteAllById(id);
    }
}
