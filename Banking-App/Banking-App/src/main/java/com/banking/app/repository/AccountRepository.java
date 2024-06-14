package com.banking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.app.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
