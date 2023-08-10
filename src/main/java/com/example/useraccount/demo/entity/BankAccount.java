package com.example.useraccount.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.ToString;

@Entity
@Table(name = "BANK_ACCOUNT_DETAILS")
@ToString
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private int accountId;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	
	@Column(name = "BANK_NAME")
	private String bankName;
	
	@Column(name = "BANK_ACCOUNT_COUNTRY")
	private String bankAccountCountry;

	@Column(name = "BANK_ACCOUNT_HOLDER")
	private String bankAccountHolder;

	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "MY_USER_ID")
	 @ToString.Exclude
	private Member user;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getAccountId() {
		return accountId;
	}

	public void setId(int id) {
		this.accountId = id;
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
	
	public Member getUser() {
		return user;
	}

	public void setUser(Member user) {
		this.user = user;
	}

}
