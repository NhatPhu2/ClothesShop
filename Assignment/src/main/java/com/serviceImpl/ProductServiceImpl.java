package com.serviceImpl;

import com.DAO.ProductDAO;
import com.DTO.ProductDto;
import com.entity.Product;
import com.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductDto> findAll() {
        List<Product> listProduct = productDAO.findAll();
        List<ProductDto> listProductDTO = modelMapper.map(listProduct, new TypeToken<List<ProductDto>>() {
        }.getType());
        return listProductDTO;

    }

    @Override
    public ProductDto findById(Integer id) {
        Optional<Product> product = productDAO.findById(id);
        return modelMapper.map(product.get(), ProductDto.class);
    }

    @Override
    public ProductDto create(ProductDto ProductDto) {
        Product newProduct = new Product();
        newProduct = modelMapper.map(ProductDto, Product.class);
        newProduct = productDAO.save(newProduct);
        return modelMapper.map(newProduct, ProductDto.class);
    }

    @Override
    public ProductDto update(ProductDto ProductDto) {
        Product newProduct = new Product();
        Optional<Product> oldProduct = productDAO.findById(ProductDto.getId());
        newProduct = modelMapper.map(ProductDto, oldProduct.get().getClass());
        return modelMapper.map(newProduct, ProductDto.class);
    }

    @Override
    public void remove(List<Integer> id) {
        productDAO.deleteAllById(id);

    }
}
