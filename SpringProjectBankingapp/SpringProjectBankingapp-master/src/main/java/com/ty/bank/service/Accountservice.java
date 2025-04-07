package com.ty.bank.service;

import java.util.List;

import com.ty.bank.dto.AccountDto;

public interface Accountservice {

	
	AccountDto createaccount(AccountDto accountDto);
	
	
	AccountDto getAccountByid(Long id);
	
	AccountDto deposit(long id,double amount);
	
	AccountDto withdraw(long id ,double amount);
	
	List<AccountDto> getAll();
	
	void deleteAccount(long id);
}
