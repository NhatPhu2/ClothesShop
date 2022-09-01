package com.DTO;

import com.entity.Customer;
import com.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class FavoriteDTO implements Serializable {
    private Integer idFavorite;
    private Date likeDate;
    private Product favoriteProduct;
    private Customer favoriteCustomer;
}
