package com.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findByType(String type);
	
	Account findByAccountId(Long id);

	Account findByAccountName(String accountName);
}
