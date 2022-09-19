package com.controller;

import com.DTO.ProductStyleDTO;
import com.service.ProductStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class ProductStyleController {

    @Autowired
    ProductStyleService productStyleService;

    @GetMapping("product-style/show/{idCategory}")
    public ResponseEntity<List<ProductStyleDTO>> showAll(@PathVariable Integer idCategory){
      return  ResponseEntity.ok(productStyleService.findAllByIdCategory(idCategory));
    }


}
