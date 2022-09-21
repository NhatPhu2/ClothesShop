package com.controller;

import com.DTO.ColorDTO;
import com.DTO.ProductColorsDTO;
import com.DTO.SizeDTO;
import com.service.ProductColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
public class ProductColorsController {

    @Autowired
    ProductColorsService productColorsService;


    @GetMapping("productcolor/detail/{idProduct}/{idColor}")
    public ResponseEntity<ProductColorsDTO>  detailColorProduct(@PathVariable Integer idProduct,
                                                                @PathVariable Integer  idColor){
        ProductColorsDTO productColorsDTO = productColorsService.findByIdColorAndIdProduct(idColor,idProduct);
        return ResponseEntity.ok(productColorsDTO);
    }


    @GetMapping("productcolor/{idColor}")
    public ResponseEntity<List<ProductColorsDTO>> getAllProductByColor(@PathVariable Integer idColor){
        return ResponseEntity.ok(productColorsService.findByColor(idColor));
    }

    @PostMapping("admin/productcolor")
    public ResponseEntity<ProductColorsDTO> addNewProductColor(@Valid @RequestBody ProductColorsDTO productColorsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productColorsService.create(productColorsDTO));
    }

    @PutMapping("admin/productcolor")
    public ResponseEntity<ProductColorsDTO> updateProductColor(@Valid @RequestBody ProductColorsDTO productColorsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productColorsService.create(productColorsDTO));
    }

    @DeleteMapping("admin/productcolor/{idProductColor}")
    public ResponseEntity deleteProductColor(@PathVariable Integer idProductColor){
        productColorsService.remove(idProductColor);
        return ResponseEntity.ok().build();
    }


    @GetMapping("colors/byproduct/{idProduct}")
    public List<ColorDTO> getColorsByIdProduct(@PathVariable Integer idProduct){
        return productColorsService.findByIdProduct(idProduct);
    }

}
