package com.account.service;

import java.util.List;

import com.account.model.Account;
import com.account.model.ServiceResponse;

public interface AccountService {

	List<Account> getAccounts(String type);

	ServiceResponse addAccount(Account sccount);

	Account getAccount(Long id);

	ServiceResponse updateAccount(Account account);

	ServiceResponse deleteAccount(Long id);

	List<Account> findAll();

}
