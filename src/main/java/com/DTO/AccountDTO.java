package com.DTO;

import com.entity.Customer;
import com.entity.Employee;
import com.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class AccountDTO implements Serializable {
    private String username;
    private String password;
    private Customer customer;
    private Employee employee;
    private Role role;
}
