package com.example.useraccount.demo.dto;

public class BankAccountDto {
	private String accountNumber;
	
	private String bankName;
	
	private String bankAccountCountry;

	private String bankAccountHolder;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountCountry() {
		return bankAccountCountry;
	}

	public void setBankAccountCountry(String bankAccountCountry) {
		this.bankAccountCountry = bankAccountCountry;
	}

	public String getBankAccountHolder() {
		return bankAccountHolder;
	}

	public void setBankAccountHolder(String bankAccountHolder) {
		this.bankAccountHolder = bankAccountHolder;
	}



}