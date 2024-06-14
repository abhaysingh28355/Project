package com.banking.app.ServiceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import com.banking.app.AccountDto.AccountDto;
import com.banking.app.Service.AccountService;
import com.banking.app.accountMapper.AccountMapper;
import com.banking.app.entities.Account;
import com.banking.app.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createaccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account saveAccount=accountRepository.save(account);
		return AccountMapper.mapToAccount(saveAccount);
	}



	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does't exis"));
		return AccountMapper.mapToAccount(account);
	}



	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does't exis"));
		double total = account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccount(savedAccount);
	}



	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does't exis"));
		if(account.getBalance()<amount) {
		throw new RuntimeException("insufficient amount");
		}
		double total = account.getBalance()-amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccount(savedAccount);
	}



	@Override
	public List<AccountDto> getAllAccount() {
	List<Account>Account=accountRepository.findAll();
	return Account.stream().map((account)-> AccountMapper.mapToAccount(account)).collect(Collectors.toList());
		
	}



	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does't exis"));
		accountRepository.deleteById(id);
		
	}

}
