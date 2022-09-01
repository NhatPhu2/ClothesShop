package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name ="idcustomer")
    Customer customer;

    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "idemployee")
    Employee employee;

    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "idrole")
    Role role;
}
