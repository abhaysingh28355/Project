package com.banking.app.accountMapper;

import com.banking.app.AccountDto.AccountDto;
import com.banking.app.entities.Account;

public class AccountMapper {

	public static Account mapToAccount(AccountDto accountDto) {
		
		Account account = new Account(
			accountDto.getId(),
			accountDto.getAccountHolderName(),
			accountDto.getBalance()	
		);
		return account;
	}
	public static AccountDto mapToAccount(Account account) {
		
		AccountDto accountDto = new AccountDto(
			account.getId(),
			account.getAccountHolderName(),
			account.getBalance()	
		);
		return accountDto;
	}
}
