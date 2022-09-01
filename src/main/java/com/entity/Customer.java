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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;
    @Column(nullable = false,columnDefinition = "nvarchar(60)")
    private String fullname;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(length = 50)
    private String photo;
    @Column(length = 50)
    private String phoneNumber;

    @OneToMany(mappedBy = "favoriteCustomer",fetch = FetchType.LAZY)
    List<Favorite> favorites;

    @OneToMany(mappedBy = "commentCustomer",fetch = FetchType.LAZY)
    List<Comment> comments;

    @OneToMany(mappedBy = "orderCustomer",fetch = FetchType.LAZY)
    List<Orders> orders;

    @OneToOne(mappedBy = "customer")
    Account account;
}
