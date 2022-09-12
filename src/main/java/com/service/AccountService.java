package com.service;

import com.DTO.AccountDTO;

import java.util.List;

public interface AccountService {
    List<AccountDTO> findAll();
    AccountDTO findById(Integer id);
    AccountDTO create(AccountDTO AccountDto);
    AccountDTO update(AccountDTO AccountDto);
    void remove(Integer id);
}
