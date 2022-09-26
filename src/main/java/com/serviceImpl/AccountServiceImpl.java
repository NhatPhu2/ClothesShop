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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO accountDAO;

	@Autowired
	Convert convert;

	@Override
	public List<AccountDTO> findAll() {
		
		return accountDAO.findAll().stream().map(t -> convert.toDto(t, AccountDTO.class)).collect(Collectors.toList());
	}

	@Override
	public AccountDTO findById(String id) {
		Account account = accountDAO.findById(id).orElse(null);
		if (account == null)
			return null;
		else
			return convert.toDto(account, AccountDTO.class);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class, Throwable.class })
	public AccountDTO create(AccountDTO AccountDto) {
		Account newAccount = convert.toEntity(AccountDto, Account.class);
		AccountDTO AccountDto2 = convert.toDto(accountDAO.save(newAccount), AccountDTO.class);
		return AccountDto2;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class, Throwable.class })
	public AccountDTO update(AccountDTO AccountDto) {
		Account newAccount = convert.toEntity(AccountDto, Account.class);
		AccountDTO AccountDto2 = convert.toDto(accountDAO.save(newAccount), AccountDTO.class);
		return AccountDto2;
	}

	@Override
	public void remove(Integer id) {

	}
}
