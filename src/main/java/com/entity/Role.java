package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id @Column(length = 100)
    private String idRole;
    @Column(nullable = false,columnDefinition = "nvarchar(50)")
    private String nameRole;

    @OneToOne(mappedBy = "role")
    Account account;
}
