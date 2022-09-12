package com.controller;

import com.DTO.ProductSizesDTO;
import com.service.ProductSizesService;
import com.service.ProductStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductSizesController {
    @Autowired
    ProductSizesService productSizesService;


    @GetMapping("productsizes/show/allsize/{idProduct}")
    public ResponseEntity<List<ProductSizesDTO>> getAllSizeOfProduct(@PathVariable Integer idProduct){
        return ResponseEntity.ok(productSizesService.findByIdProduct(idProduct));
    }
}
