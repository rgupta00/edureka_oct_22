package com.bankapp.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountDetailsDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@RestController//  =@Controller+ @ResponseBody
@RequestMapping(path = "api")
public class AccountApi {
	
	private AccountService accountService;
	
	@Autowired
	public AccountApi(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//--------------get all accounts-------------------
	@GetMapping(path = "accounts", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	//--------------get an specific account by id-------------------
	@GetMapping(path = "accounts/{id}")
	public Account getAccountById(@PathVariable(name = "id")  int id){
		return accountService.getById(id);
	}
	
	//-------------update the account email id or phone no-------------------
	@PutMapping(path = "accounts/{id}")
	public Account updateAccountDetails(@PathVariable(name = "id")  int id,
			@RequestBody AccountDetailsDto accountDetailsDto){
		//i should call the update method
		return accountService.updateAccountDetails(id, accountDetailsDto);
	}
	
	//-------------delete an account by id-------------------
	@DeleteMapping(path = "accounts/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id")  int id){
		 accountService.deleteAccount(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//-------------add new account-------------------
	@PostMapping(path = "accounts")
	public ResponseEntity<Account> addAccount(@RequestBody Account account){
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.addAccount(account));
	}

}







