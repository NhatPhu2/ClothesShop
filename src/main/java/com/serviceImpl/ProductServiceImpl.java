package com.serviceImpl;

import com.DAO.ProductDAO;
import com.DTO.ProductDTO;
import com.entity.Product;
import com.service.ProductService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    Convert convert;

    @Override
    public List<ProductDTO> findAll() {
        List<Product> listProduct = productDAO.findAll();
        List<ProductDTO> listProductDTO = listProduct.stream().
                map(product -> convert.toDto(product, ProductDTO.class))
                .collect(Collectors.toList());
        return listProductDTO;

    }

    @Override
    public ProductDTO findById(Integer id) {
        Product product = productDAO.findById(id).get();
        return convert.toDto(product, ProductDTO.class);
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public ProductDTO create(ProductDTO ProductDto) {
        Product newProduct = convert.toEntity(ProductDto, Product.class);
        ProductDTO productDto = convert.toDto(productDAO.save(newProduct), ProductDTO.class);
        return productDto;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public ProductDTO update(ProductDTO ProductDto) {
        Product newProduct = convert.toEntity(ProductDto,Product.class);
        ProductDTO productDto = convert.toDto(productDAO.save(newProduct), ProductDTO.class);
        return productDto;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void remove(List<Integer> id) {
        productDAO.deleteAllById(id);
    }

    @Override
    public List<ProductDTO> findAllByIdCategory(Integer idCategory) {
        List<Product> products = productDAO.findAllByIdCategory(idCategory);
        List<ProductDTO> productDTOS = products.stream()
                .map(product -> convert.toDto(product,ProductDTO.class))
                .collect(Collectors.toList());
        return productDTOS;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
	public List<ProductDTO> page(int size, int page) {
    	Pageable pageable = PageRequest.of(page, size);
    	Page<Product> pages = productDAO.findAll(pageable);
    	return pages.stream().map(t -> convert.toDto(t, ProductDTO.class)).collect(Collectors.toList());
	}

}
