package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productsizes")
public class ProductSizes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProductSizes;
    @Column(nullable = false)
    private int quantity;
    @ManyToOne @JoinColumn(name = "idsize")
    private Size sizeProduct;
    @ManyToOne @JoinColumn(name = "idProductsColors")
    private ProductColors productColors;


}
