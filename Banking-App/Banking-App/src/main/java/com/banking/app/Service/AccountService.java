package com.banking.app.Service;

import java.util.List;

import com.banking.app.AccountDto.AccountDto;

public interface AccountService {

	AccountDto createaccount(AccountDto accountDto);
	AccountDto getAccountById(Long id);
	AccountDto deposit(Long id,double amount);
	AccountDto withdraw(Long id,double amount);
	List<AccountDto> getAllAccount();
	void deleteAccount(Long id);
}
