package com.controller;


import com.DTO.ProductDTO;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/controller")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products/all")
    public List<ProductDTO> getAllProducts() {
        return productService.findAll();
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
