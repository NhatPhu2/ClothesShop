package com.controller;

import com.DTO.ProductColorsDTO;
import com.service.ProductColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ProductColorsController {

    @Autowired
    ProductColorsService productColorsService;


    @GetMapping("productcolor/show/detail/{idProduct}/{idColor}")
    public ResponseEntity<ProductColorsDTO>  detailColorProduct(@PathVariable Integer idProduct,
                                                                @PathVariable Optional<Integer>  idColor){
        ProductColorsDTO productColorsDTO = productColorsService.findByIdColorAndIdProduct(idColor.orElse(1),idProduct);
        return ResponseEntity.ok(productColorsDTO);
    }

    @GetMapping("productcolor/show/allcolor/{idProduct}")
    public ResponseEntity<List<ProductColorsDTO>> getAllColorOfProduct(@PathVariable Integer idProduct){
        return ResponseEntity.ok(productColorsService.findByIdProduct(idProduct));
    }



}
