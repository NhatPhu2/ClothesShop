package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFavorite;
    @Column(nullable = false)
    private Date likeDate;

    @ManyToOne @JoinColumn(name = "idproduct")
    private Product favoriteProduct;
    @ManyToOne @JoinColumn(name = "username")
    private Account favoriteAccount;

}
