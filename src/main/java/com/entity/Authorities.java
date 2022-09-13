package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthorities;
    @ManyToOne @JoinColumn(name ="username")
    private Account authorityAccount;
    @ManyToOne @JoinColumn(name ="idRole")
    private Role authorityRole;

}