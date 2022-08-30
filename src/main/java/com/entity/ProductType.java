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
@Table(name = "producttype")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,columnDefinition = "nvarchar(50)")
    private String name;

    @OneToMany(mappedBy = "productType",fetch = FetchType.LAZY)
    private List<Product> products;

    @ManyToOne @JoinColumn(name = "idcategory")
    Category categoryType;
}
