package com.DTO;

import com.entity.Customer;
import com.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class FavoriteDTO implements Serializable {
    private Integer id;
    private Date likeDate;
    private Product favoriteProduct;
    private Customer favoriteCustomer;
}
