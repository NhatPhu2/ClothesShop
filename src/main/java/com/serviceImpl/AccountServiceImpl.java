package com.serviceImpl;

import com.DAO.AccountDAO;
import com.DTO.AccountDTO;
import com.entity.Account;
import com.entity.Product;
import com.service.AccountService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO accountDAO;

    @Autowired
    Convert convert;
    @Override
    public List<AccountDTO> findAll() {
        return null;
    }

    @Override
    public AccountDTO findById(Integer id) {
        return null;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public AccountDTO create(AccountDTO AccountDto) {
        Account newAccount = convert.toEntity(AccountDto, Account.class);
        AccountDTO AccountDto2 = convert.toDto(accountDAO.save(newAccount), AccountDTO.class);
        return AccountDto2;
    }

    @Override
    public AccountDTO update(AccountDTO AccountDto) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
