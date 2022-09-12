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
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComment;
    @Column(nullable = false,columnDefinition = "nvarchar(100)")
    private String description;
    @Column(nullable = false)
    private Date commentDate;

    @ManyToOne @JoinColumn(name = "idproduct")
    private Product commentProduct;

    @ManyToOne @JoinColumn(name = "idcustomer")
    private Customer commentCustomer;
}
