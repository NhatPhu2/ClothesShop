package com.controller;


import com.DTO.ProductDTO;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product/all")
    public ResponseEntity<List<ProductDTO>>  getAllProducts() {

        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/product/bycategory/{idCategory}")
    public ResponseEntity<List<ProductDTO>> showByIdCategory(@PathVariable Integer idCategory){
        return ResponseEntity.ok(productService.findAllByIdCategory(idCategory));
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }

    @PostMapping("/admin/create")
    public ProductDTO createProduct(@RequestBody ProductDTO product){
        return productService.create(product);
    }

    @PutMapping("/admin/update")
    public ProductDTO updateProduct(@RequestBody ProductDTO product){
        return productService.update(product);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteProduct(@PathVariable("id") List<Integer> id) {
        productService.remove(id);
    }
}
