package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"idcustomer","idproduct"})
})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String description;

    @ManyToOne @JoinColumn(name = "idproduct")
    private Product commentProduct;

    @ManyToOne @JoinColumn(name = "idcustomer")
    private Customer commentCustomer;
}
