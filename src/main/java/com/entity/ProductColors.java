package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productcolors")
public class ProductColors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProductColor;
    @Column(nullable = false,length = 70)
    private String photo;
    @ManyToOne @JoinColumn(name = "idproduct")
    private Product product;
    @ManyToOne @JoinColumn(name = "idcolor")
    private Color colorProduct;
}
