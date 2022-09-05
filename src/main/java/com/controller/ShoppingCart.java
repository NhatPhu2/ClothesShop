package com.controller;


import com.DTO.ProductDTO;
import com.pojo.Cart;
import com.service.ProductService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("cart")
public class ShoppingCart {
//    @Autowired
//    ProductService productService;
//
//    @PostMapping("add/{id}")
//    public ResponseEntity<Map<Integer,Cart>> add(@PathVariable("id")Integer id,
//                                                @RequestBody Optional<Map<Integer,Cart>> existCart){
//        //nếu chưa có sản phẩm trong giỏ thì tạo mới
//        Map<Integer,Cart> carts = existCart.orElse(new HashMap<>());
//        if(carts.containsKey(id)){//nếu thêm sản phẩm đã có thì tăng số lượng thêm 1
//            Cart c = carts.get(id);
//            c.setQuantity(c.getQuantity() + 1);
//            carts.put(c.getIdProduct(),c);
//        }else{
//            ProductDTO productDTO = productService.findById(id);
//            productDTO.setQuantity(1);
//            Cart cart = new Cart();
//            try{
//                BeanUtils.copyProperties(cart,productDTO);//copy thuộc tính
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            carts.put(cart.getIdProduct(),cart);
//        }
//        return ResponseEntity.ok(carts);
//    }
//
//    @GetMapping("show")
//    public void changeQuantity(){
//
//    }

}
