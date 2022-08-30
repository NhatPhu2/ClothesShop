package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double amount;
    @ManyToOne @JoinColumn(name = "idproduct")
    private Product orderDetailProduct;

    @ManyToOne @JoinColumn(name = "idorder")
    private Orders order;


}
