package com.ty.bank.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bank.dto.AccountDto;
import com.ty.bank.entity.Account;
import com.ty.bank.mapper.AccountMapper;
import com.ty.bank.repository.Accountrepository;
import com.ty.bank.service.Accountservice;

@Service
public class AccountServiceImplementation implements Accountservice{
	


	@Autowired
	private Accountrepository accountrepository;	


	public  AccountDto AccountServiceimpl(Accountrepository accountrepository) {
		//return this.accountrepository = accountrepository;
		return null;
	}


	@Override
	public AccountDto createaccount(AccountDto accountDto) {
		Account account =AccountMapper.mapToAccount(accountDto);
		Account savedaccount=accountrepository.save(account);

		return AccountMapper.maptoAccountDto(savedaccount); 
	}


	@Override
	public AccountDto getAccountByid(Long id) {

		Account account=accountrepository.findById(id).orElseThrow(() ->new  RuntimeException("id does not exists"));
		return AccountMapper.maptoAccountDto(account);


	}
	@Override
	public AccountDto deposit(long id, double amount) {

		Account account=accountrepository.findById(id).orElseThrow(()->new RuntimeException("id does nt exixst"));
		double	balance=account.getBalance();
		balance=balance+amount;
		account.setBalance(balance);
		Account savedaccount=accountrepository.save(account);
		return AccountMapper.maptoAccountDto(savedaccount);
	}


	@Override
	public AccountDto withdraw(long id, double amount) {
		Account account=accountrepository.findById(id).orElseThrow(()->new RuntimeException("id does nt exixst"));
		if (account.getBalance()<amount) {
			throw new RuntimeException("infsuffient balance");
		}

		double total=account.getBalance()-amount;

		account.setBalance(total);
		Account savedacAccount=accountrepository.save(account);

		return AccountMapper.maptoAccountDto(savedacAccount);
	}


	@Override
	public List<AccountDto> getAll() {
		List<Account> accounts=accountrepository.findAll();
		return (List<AccountDto>) accounts.stream().map((account)->AccountMapper.maptoAccountDto(account))
				.collect(Collectors.toList());
	}


	@Override
	public void deleteAccount(long id) {
		Account account=accountrepository.findById(id).orElseThrow(()->new RuntimeException("id does nt exixst"));
		
		accountrepository.deleteById(id);
	}

}
