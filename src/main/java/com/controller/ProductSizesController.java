package com.controller;

import com.DTO.ProductDTO;
import com.DTO.ProductSizesDTO;
import com.DTO.SizeDTO;
import com.service.ProductSizesService;
import com.service.ProductStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
public class ProductSizesController {
    @Autowired
    ProductSizesService productSizesService;

    @PostMapping("admin/productsizes")
    public ResponseEntity<ProductSizesDTO> addNewProductSize(@Valid @RequestBody ProductSizesDTO productSizesDTO){
       return ResponseEntity.status(HttpStatus.CREATED).body(productSizesService.create(productSizesDTO));
    }
    @PutMapping("admin/productsizes")
    public ResponseEntity<ProductSizesDTO> updateProductSize(@Valid @RequestBody ProductSizesDTO productSizesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productSizesService.create(productSizesDTO));
    }

    @DeleteMapping("admin/productsize/{idProductSize}")
    public ResponseEntity deleteProductSize(@PathVariable Integer idProductSize){
        productSizesService.remove(idProductSize);
        return ResponseEntity.ok().build();
    }

    @GetMapping("size/{idProductColor}")
    public List<SizeDTO> getSizesByIdProduct(@PathVariable Integer idProductColor){
        return productSizesService.findByIdProductColor(idProductColor);
    }

}
