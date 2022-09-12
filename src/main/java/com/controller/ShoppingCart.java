package com.controller;


import com.DTO.*;

import com.pojo.Cart;
import com.service.*;
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
    ProductService productService;

    @PostMapping("add/{id}/{idSize}/{idColor}")
    public ResponseEntity<Map<String, Cart>> add(@PathVariable("id") Integer idProduct,
                                                 @PathVariable("idSize") Integer idSize,
                                                 @PathVariable("idColor") Integer idColor,
                                                 @RequestBody Optional<Map<String, Cart>> existCart) {
        //nếu chưa có sản phẩm trong giỏ thì tạo mới
        Map<String, Cart> carts = existCart.orElse(new HashMap<>());
        String key = idProduct + "/" + idSize;
        if (carts.containsKey(key)) {//nếu id sản phẩm và size sản phẩm trùng nhua thì tăng số lượng lên 1
            Cart c = carts.get(key);
            c.setQuantity(c.getQuantity() + 1);
            carts.put(key, c);
        } else {
            ProductColorsDTO productColorsDTO = productColorsService.findByIdColorAndIdProduct(idColor, idProduct);
            ProductSizesDTO productSizesDTO = productSizesService.findByIdProductAndIdSize(idProduct, idSize);
            ProductDTO productDTO = productService.findById(idProduct);
            Cart cart = new Cart();
            try {
                BeanUtils.copyProperties(cart, productDTO);//copy thuộc tính
                cart.setNameColor(productColorsDTO.getNameColor());
                cart.setPhoto(productColorsDTO.getPhotoColor());
                cart.setIdColor(productColorsDTO.getIdColor());
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
            ProductSizesDTO productSizesDTO = productSizesService.findByIdProductAndIdSize(valueCart.getIdProduct(),valueCart.getIdSize());
            productSizesDTO.setQuantity(productSizesDTO.getQuantity() - valueCart.getQuantity());
            productSizesService.update(productSizesDTO);

            //thanh toán và trả về hóa đơn chi tiết cho người dùng
            orderDetailDTO.setQuantity(valueCart.getQuantity());
            orderDetailDTO.setAmount(valueCart.getQuantity() * valueCart.getPrice());
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
