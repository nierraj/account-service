package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.Account;
import com.account.model.ServiceResponse;
import com.account.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

	@Autowired
	AccountService accountService;

	@PostMapping(path = "/create", consumes = { "application/json" })
	public ResponseEntity<ServiceResponse> createAccount(@RequestBody Account account) {
		ServiceResponse serviceResponse = accountService.addAccount(account);
		return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
	}


	@GetMapping(path = "")
	public ResponseEntity<List<Account>> getAccount() {
		return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);

	}

	@PutMapping(path = "", consumes = { "application/json" })
	public ResponseEntity<ServiceResponse> saveOrUpdateAccount(@RequestBody Account account) {
		ServiceResponse serviceResponse = accountService.updateAccount(account);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
		Account account = accountService.getAccount(id);
		return new ResponseEntity<>(account, HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResponse> deleteAccount(@PathVariable Long id) {
		ServiceResponse serviceResponse = accountService.deleteAccount(id);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}
