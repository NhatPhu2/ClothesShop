package com.service;

import com.DTO.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> findAll();
    AccountDto findById(Integer id);
    void create(AccountDto AccountDto);
    void update(AccountDto AccountDto);
    void remove(Integer id);
}
