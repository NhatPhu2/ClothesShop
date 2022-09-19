package com.controller;

import com.DTO.ProductDTO;
import com.DTO.ProductSizesDTO;
import com.service.ProductSizesService;
import com.service.ProductStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
public class ProductSizesController {
    @Autowired
    ProductSizesService productSizesService;


    @GetMapping("productsizes/show/allsize/{idProduct}")
    public ResponseEntity<List<ProductSizesDTO>> getAllSizeOfProduct(@PathVariable Integer idProduct){
        return ResponseEntity.ok(productSizesService.findByIdProduct(idProduct));
    }

    @GetMapping("productsizes/show/byidsize/{idSize}")
    public ResponseEntity<List<ProductDTO>> getAllProductBySize(@PathVariable Integer idSize){
        return ResponseEntity.ok(productSizesService.findByIdSize(idSize));
    }

}
