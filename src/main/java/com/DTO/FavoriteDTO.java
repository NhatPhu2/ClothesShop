package com.DTO;

import com.entity.Customer;
import com.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class FavoriteDTO implements Serializable {
    private Integer idFavorite;
    private Date likeDate;
    @JsonIgnore
    private Product favoriteProduct;
    @JsonIgnore
    private Customer favoriteCustomer;
}
