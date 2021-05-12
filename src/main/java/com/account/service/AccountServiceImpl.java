package com.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.exception.AccountAlreadyPresentException;
import com.account.exception.AccountNotFoundException;
import com.account.model.Account;
import com.account.model.ServiceResponse;
import com.account.repository.AccountRepository;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> getAccounts(String type) {
		List<Account> accounts;
		if (type != null) {
			accounts = accountRepository.findByType(type);
		} else {
			accounts = accountRepository.findAll();
		}
		if (accounts == null || accounts.isEmpty()) {
			throw new AccountNotFoundException("No Accounts found!");
		}
		return accounts;
	}

	@Override
	public ServiceResponse addAccount(Account account) {
		if (null != accountRepository.findByAccountId(account.getAccountId())) {
			throw new AccountAlreadyPresentException("Account already present!");
		} else {
			accountRepository.save(account);
		}
		return new ServiceResponse("Successful", "Account added successfully");
	}

	@Override
	public Account getAccount(Long id) {
		Account account = accountRepository.findByAccountId(id);
		if (account == null)
			throw new AccountNotFoundException("Invalid product id!");

		return account;
	}

	@Override
	public ServiceResponse updateAccount(Account product) {
		accountRepository.save(product);
		return new ServiceResponse("Successful", "Account updated successfully");
	}

	@Override
	public ServiceResponse deleteAccount(Long id) {
		Account account = accountRepository.findByAccountId(id);
		if (account != null) {
			accountRepository.delete(account);
		} else {
			throw new AccountNotFoundException("Invalid Account id!");
		}
		return new ServiceResponse("Successful", "Account deleted successfully");
	}

	@Override
	public List<Account> findAll() {
		List<Account> accounts = accountRepository.findAll();
		return accounts;
	}

}
