package com.example.useraccount.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.useraccount.demo.dto.BankAccountDto;
import com.example.useraccount.demo.dto.MemberDto;
import com.example.useraccount.demo.entity.BankAccount;
import com.example.useraccount.demo.service.BankAccountService;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RestController
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;
	
	@GetMapping("/getbanks")  
	private List<BankAccount> getAllBanks()   
	{  
	return bankAccountService.getAllBanks();  
	}   

	@DeleteMapping("/delete/banks/{bankId}")  
	private void deleteBankAccount(@PathVariable("bankId") int bankId)   
	{  
		bankAccountService.delete(bankId);  
	} 
	
	@PostMapping(value = "/banks", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BankAccount> saveBankAccount(@RequestBody BankAccountDto bankAccountDto) {

		BankAccount persistedEmp = bankAccountService.save(bankAccountDto);

		return new ResponseEntity<>(persistedEmp, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/account/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<MemberDto>> getMembersByCountry(@PathVariable final String country) {

		ArrayList<MemberDto> salaryAcc = bankAccountService.getMemberByBranch(country);

		return new ResponseEntity<>(salaryAcc, HttpStatus.OK);
	}
}
