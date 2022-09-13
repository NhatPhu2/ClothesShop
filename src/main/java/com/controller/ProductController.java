package com.controller;


import com.DTO.ProductDTO;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product/all")
    public ResponseEntity<List<ProductDTO>>  getAllProducts() {

        return ResponseEntity.ok(productService.findAll());
    }
    
    @GetMapping("/products/all/{page}/{size}")
    public List<ProductDTO> paging(@PathVariable("page") Optional<Integer> page, @PathVariable("size") Optional<Integer> size ) {
        return productService.page(size.orElseThrow(() -> {throw new RuntimeException("page isn't error!");}),page.orElseThrow(() ->{throw new RuntimeException("page isn't error!");}));
    }
    
    @GetMapping("/products/price/{min}/{max}")
    public ResponseEntity<List<ProductDTO>> getProductByMinMaxPrice(@PathVariable("min") Optional<Double> min,@PathVariable("max") Optional<Double> max ){
    	double mi = min.orElse(0.0);
    
    	double ma = max.orElse(productService.findAll().stream().mapToDouble(p -> p.getPrice()).max().getAsDouble());
    	List<ProductDTO> list = productService.findAll().stream().filter(t -> (t.getPrice()>=mi && t.getPrice()<=ma)).collect(Collectors.toList());
    	return ResponseEntity.ok(list);
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
