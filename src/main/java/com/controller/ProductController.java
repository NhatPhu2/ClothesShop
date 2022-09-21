package com.controller;


import com.DTO.ProductColorsDTO;
import com.DTO.ProductDTO;
import com.DTO.ProductSizesDTO;
import com.entity.ProductSizes;
import com.google.api.gax.rpc.NotFoundException;
import com.service.ProductColorsService;
import com.service.ProductService;
import com.service.ProductSizesService;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")


@Validated
@RequestMapping("api/v1")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductColorsService productColorsService;

    @Autowired
    ProductSizesService productSizesService;


    @GetMapping("/products")
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
    
    @GetMapping("/products/bycategory/{idCategory}")
    public ResponseEntity<List<ProductDTO>> showByIdCategory(@PathVariable Integer idCategory){
        return ResponseEntity.ok(productService.findAllByIdCategory(idCategory));
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }

    @PutMapping("/admin/products")
    public ProductDTO updateProduct(@RequestBody ProductDTO product){
        return productService.update(product);
    }

    @GetMapping("products/bystyle/{idStyle}/{idCategory}")
    public ResponseEntity<List<ProductDTO>> getAllProductByStyle(@PathVariable Integer idStyle,
                                                                 @PathVariable Integer idCategory){
        return ResponseEntity.ok(productService.fillByIdCategoryAndIdStyle(idCategory,idStyle));
    }

    @PostMapping("/admin/products")
    public ResponseEntity<ProductDTO> addNewProduct(@Valid @RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productDTO));
    }


    @DeleteMapping("/admin/products")
    public void deleteProduct(@RequestParam @NotNull(message = "Vui lòng chọn ít nhất 1 sản phẩm để xóa")
                                  List<Integer> idProduct){
        productService.remove(idProduct);
    }
    
}

