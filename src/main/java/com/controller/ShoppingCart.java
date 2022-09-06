package com.controller;


import com.DTO.OrderDetailDTO;
import com.DTO.OrdersDTO;
import com.DTO.ProductColorsDTO;

import com.DTO.ProductSizesDTO;
import com.entity.OrderDetail;
import com.entity.Orders;
import com.pojo.Cart;
import com.service.OrderDetailService;
import com.service.OrdersService;
import com.service.ProductColorsService;
import com.service.ProductSizesService;
import com.utils.Convert;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("cart")
public class ShoppingCart {

    @Autowired
    ProductColorsService productColorsService;

    @Autowired
    ProductSizesService productSizesService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    Convert convert;

    @PostMapping("add/{id}/{idSize}/{idColor}")
    public ResponseEntity<Map<String, Cart>> add(@PathVariable("id") Integer idProduct,
                                                 @PathVariable("idSize") Integer idSize,
                                                 @PathVariable("idColor") Integer idColor,
                                                 @RequestBody Optional<Map<String, Cart>> existCart) {
        //nếu chưa có sản phẩm trong giỏ thì tạo mới
        Map<String, Cart> carts = existCart.orElse(new HashMap<>());
        String key = idSize + "/" + idProduct;
        if (carts.containsKey(key)) {//nếu id sản phẩm và size sản phẩm trùng nhua thì tăng số lượng lên 1
            Cart c = carts.get(key);
            c.setQuantity(c.getQuantity() + 1);
            carts.put(key, c);
        } else {
            ProductColorsDTO productColorsDTO = productColorsService.findByIdColorAndIdProduct(idColor, idProduct);
            ProductSizesDTO productSizesDTO = productSizesService.findByIdProduct(idProduct, idSize);
            Cart cart = new Cart();
            try {
                BeanUtils.copyProperties(cart, productColorsDTO);//copy thuộc tính
                cart.setQuantity(1);
                cart.setNameSize(productSizesDTO.getNameSize());
                cart.setIdSize(productSizesDTO.getIdSize());
            } catch (Exception e) {
                e.printStackTrace();
            }
            carts.put(key, cart);
        }
        return ResponseEntity.ok(carts);
    }

    @PostMapping("pay") //thanh toán
    public ResponseEntity<List<OrderDetailDTO>> pay(@RequestBody Map<String, Cart> cart, @RequestParam(required = false) String address) {
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setAddress("address");
        ordersDTO.setCreateDate(new Date());
        Integer idOder = ordersService.create(ordersDTO).getIdOrder();//thêm vào bảng hóa đơn và trả về id hóa đơn
        //-----------------------------
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        List<OrderDetailDTO> orderDetailDTOS = cart.values().stream().map(x -> {
            orderDetailDTO.setQuantity(x.getQuantity());
            orderDetailDTO.setAmount(x.getQuantity() * x.getPrice());
            orderDetailDTO.setIdProduct(x.getIdProduct());
            orderDetailDTO.setIdOrder(idOder);
            return orderDetailService.create(orderDetailDTO);
        }).collect(Collectors.toList());//chuyển đổi map sang list
        return ResponseEntity.ok(orderDetailDTOS);//trả về hóa đơn chi tiết cho người dùng
    }


}
