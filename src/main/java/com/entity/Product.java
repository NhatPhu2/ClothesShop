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
    private Integer id;
    @Column(nullable = false,columnDefinition = "nvarchar(200)")
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false,columnDefinition = "nvarchar(200)")
    private String description;
    @Column(nullable = false, length = 70)
    private String photo;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private Date createDate;

    @ManyToOne @JoinColumn(name = "idsize")
    private Size size;

    @ManyToOne @JoinColumn(name = "idcolor")
    private Color color;

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
