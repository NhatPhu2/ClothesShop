package com.controller;


import com.DTO.ProductDTO;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("cart")
public class ShoppingCart {

    Map<Integer,ProductDTO> carts = new HashMap<>();
    @Autowired
    ProductService productService;

    @PostMapping("add/{id}")
    public Map<Integer,ProductDTO> add(@PathVariable("id")Optional<Integer> id){
        ProductDTO existCart = carts.get(id.get());
        ProductDTO cart = productService.findById(id.get());
        if(existCart !=null){
            cart.setQuantity(existCart.getQuantity() + 1);

        }
        else
            cart.setQuantity(1);
        carts.put(cart.getId(),cart);
        return  carts;
    }

    @GetMapping("show")
    public void changeQuantity(){

    }

}
