package com.ty.bank.mapper;

import com.ty.bank.dto.AccountDto;
import com.ty.bank.entity.Account;

public class AccountMapper {

	
	public static Account mapToAccount(AccountDto accountDto)
	{
		
		
		Account account=new Account(
				accountDto.getId(),
				accountDto.getAccountHoldername(),
				accountDto.getBalance());
		
		return account;
		
	}
	public static AccountDto maptoAccountDto(Account account)
	{
		AccountDto accountDto=new AccountDto(
				account.getId(),
						account.getAccountHoldername(),
				account.getBalance());
		
		
		return accountDto;
	}
	
	
}
