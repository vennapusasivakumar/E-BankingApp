package com.ty.bank.controler;

import java.util.List;
import java.util.Map;

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

import com.ty.bank.dto.AccountDto;
import com.ty.bank.entity.Account;
import com.ty.bank.service.Accountservice;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private Accountservice accountservice;

	public Accountservice getAccountservice() {
		return accountservice;
	}

	public void setAccountservice(Accountservice accountservice) {
		this.accountservice = accountservice;
	}

	// create api to add account
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<>(accountservice.createaccount(accountDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountByid(@PathVariable long id) {
		AccountDto accountDto = accountservice.getAccountByid(id);
		return ResponseEntity.ok(accountDto);
	}

	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");

		AccountDto accountDto = accountservice.deposit(id, request.get(amount));

		return ResponseEntity.ok(accountDto);

	}

	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accountservice.withdraw(id, amount);

		return (ResponseEntity<AccountDto>) ResponseEntity.ok(accountDto);

	}

	@GetMapping
	public ResponseEntity<List<AccountDto>> GetAllAccounts() {
		List<AccountDto> acconuts = accountservice.getAll();

		return ResponseEntity.ok(acconuts);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable long id) {
      accountservice.deleteAccount(id);
      return ResponseEntity.ok("Account deleted");
		
		
	}
}
