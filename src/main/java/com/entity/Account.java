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
@Table(name = "account")
public class Account {
    @Id @Column(length = 100)
    private String username;
    @Column(nullable = false,length = 100)
    private String password;
    @Column(nullable = false,columnDefinition = "nvarchar(60)")
    private String fullname;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(length = 50)
    private String photo;
    @Column(length = 50)
    private String phoneNumber;

    @OneToMany(mappedBy = "authorityAccount" , fetch = FetchType.LAZY)
    List<Authorities> authorities;

    @OneToMany(mappedBy = "commentAccount", fetch = FetchType.LAZY)
    List<Comment> comments;

    @OneToMany(mappedBy = "favoriteAccount", fetch = FetchType.LAZY)
    List<Favorite> favorites;

    @OneToMany(mappedBy = "orderAccount", fetch = FetchType.LAZY)
    List<Orders> orders;
}
