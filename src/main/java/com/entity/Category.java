package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product> products;
    @OneToMany(mappedBy = "categoryType",fetch = FetchType.LAZY)
    private List<ProductType> productTypes;

}
