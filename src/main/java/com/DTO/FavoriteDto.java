package com.DTO;

import com.entity.Customer;
import com.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
public class FavoriteDto implements Serializable {
    private final Integer id;
    private final Date likeDate;
    private final Product favoriteProduct;
    private final Customer favoriteCustomer;
}
