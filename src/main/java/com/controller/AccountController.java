package com.controller;

import com.DTO.AccountDTO;
import com.DTO.CustomerDTO;
import com.service.AccountService;
import com.service.CustomerService;
import com.utils.Convert;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    Convert convert;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CustomerService customerService;

    @PostMapping("/account")
    public AccountDTO createAccount(@RequestBody AccountDTO accountDTO){
        AccountDTO account = accountService.create(accountDTO);
        CustomerDTO customer = modelMapper.map(accountDTO, CustomerDTO.class);
        customerService.create(customer);
        return account;
    }
}
