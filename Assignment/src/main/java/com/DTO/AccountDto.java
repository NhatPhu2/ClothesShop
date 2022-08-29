package com.DTO;

import com.entity.Customer;
import com.entity.Employee;
import com.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class AccountDto implements Serializable {
    private final String username;
    private final String password;
    private final Customer customer;
    private final Employee employee;
    private final Role role;
}
