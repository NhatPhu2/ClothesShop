package com.controller;


import com.DTO.*;

import com.pojo.Cart;
import com.service.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
@Validated
public class ShoppingCart {

    @Autowired
    ProductColorsService productColorsService;

    @Autowired
    SizeService sizeService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    ProductSizesService productSizesService;

    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("user/cart/{id}/{idSize}/{idColor}")
    public ResponseEntity<Map<String, Cart>> addCart(@PathVariable("id") Integer idProduct,
                                                 @PathVariable("idSize") @Min(value = 1, message = "{NotNull.ProductSizesDTO.idSize}") Integer idSize,
                                                 @PathVariable("idColor") @Min(value = 1 , message = "{NotNull.ProductColorsDTO.idColor}") Integer idColor,
                                                 @RequestBody Optional<Map<String, Cart>> existCart) {
        //nếu chưa có sản phẩm trong giỏ thì tạo mới
        Map<String, Cart> carts = existCart.orElse(new HashMap<>());
        String key = idProduct + "/" + idSize + "/" + idColor;
        if (carts.containsKey(key)) {//nếu id sản phẩm và size sản phẩm trùng nhua thì tăng số lượng lên 1
            Cart c = carts.get(key);
            c.setQuantity(c.getQuantity() + 1);
            carts.put(key, c);
        } else {
            ProductColorsDTO productColorsDTO = productColorsService.findByIdColorAndIdProduct(idColor, idProduct);
            SizeDTO sizeDTO = sizeService.findById(idSize);
            Cart cart = new Cart();
            try {
                BeanUtils.copyProperties(cart, productColorsDTO);//copy thuộc tính
                cart.setQuantity(1);
                cart.setNameSize(sizeDTO.getNameSize());
                cart.setIdSize(sizeDTO.getIdSize());
            } catch (Exception e) {
                e.printStackTrace();
            }
            carts.put(key, cart);
        }
        return ResponseEntity.ok(carts);
    }

    @PostMapping("user/cart/payment") //thanh toán
    public ResponseEntity<List<OrderDetailDTO>> pay(@RequestBody Map<String, Cart> cart,
                                                    @RequestParam String address) {
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setAddress(address);
        ordersDTO.setCreateDate(new Date());
        Integer idOder = ordersService.create(ordersDTO).getIdOrder();//thêm vào bảng hóa đơn và trả về id hóa đơn
        //-----------------------------
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        List<OrderDetailDTO> orderDetailDTOS = cart.values().stream().map(valueCart -> {
            //cập nhật lại số lượng sản phẩm
            ProductSizesDTO productSizesDTO = productSizesService.findByIdProductColorsAndIdSize(valueCart.getIdProductsColors(),valueCart.getIdSize());
            productSizesDTO.setQuantity(productSizesDTO.getQuantity() - valueCart.getQuantity());
            productSizesService.update(productSizesDTO);
            //thanh toán và trả về hóa đơn chi tiết cho người dùng
            orderDetailDTO.setQuantity(valueCart.getQuantity());
            orderDetailDTO.setAmount(valueCart.getQuantity() * valueCart.getPriceProduct());
            orderDetailDTO.setIdProduct(valueCart.getIdProduct());
            orderDetailDTO.setColorName(valueCart.getNameColor());
            orderDetailDTO.setSizeName(valueCart.getNameSize());
            orderDetailDTO.setIdOrder(idOder);
            //
            return orderDetailService.create(orderDetailDTO);
        }).collect(Collectors.toList());//chuyển đổi map sang list
        return ResponseEntity.ok(orderDetailDTOS);//trả về hóa đơn chi tiết cho người dùng
    }

}
