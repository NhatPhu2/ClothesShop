package com.controller;

import com.DTO.ProductColorsDTO;
import com.DTO.ProductDTO;
import com.entity.Product;
import com.service.ProductColorsService;
import com.service.ProductService;
import com.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/controller")
public class ProductController {
    @Autowired
    ProductColorsService productColorsService;

    @GetMapping("/products/all")
    public List<ProductColorsDTO> getAllProducts() {
        return productColorsService.findAll();
    }

//    @GetMapping("/products/{id}")
//    public ProductDTO getProductById(@PathVariable("id") Integer id) {
//        return productService.findById(id);
//    }
//
//    @PostMapping("/products/create")
//    public ProductDTO createProduct(@RequestBody ProductDTO product){
//        return productService.create(product);
//    }
//
//    @PostMapping("/products/update")
//    public ProductDTO updateProduct(@RequestBody ProductDTO product){
//        return productService.update(product);
//    }
//
//    @DeleteMapping("/products/{id}")
//    public void deleteProduct(@PathVariable("id") List<Integer> id) {
//        productService.remove(id);
//    }
}
