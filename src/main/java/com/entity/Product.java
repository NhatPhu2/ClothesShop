package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    @Column(nullable = false,columnDefinition = "nvarchar(200)")
    private String nameProduct;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false,columnDefinition = "nvarchar(200)")
    private String description;
    @Column(nullable = false)
    private Date createDate;

    @OneToMany(mappedBy = "proSize",fetch = FetchType.LAZY)
    List<ProductSizes> productSizes;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    List<ProductColors> productColors;

    @ManyToOne @JoinColumn(name = "idcategory")
    private Category category;

    @ManyToOne @JoinColumn(name = "idproducttype")
    private ProductType productType;

    @OneToMany(mappedBy = "favoriteProduct",fetch = FetchType.LAZY)
    List<Favorite> favorites;

    @OneToMany(mappedBy = "commentProduct",fetch = FetchType.LAZY)
    List<Comment> comments;

    @OneToMany(mappedBy = "orderDetailProduct",fetch = FetchType.LAZY)
    List<OrderDetail> orderDetails;
}
