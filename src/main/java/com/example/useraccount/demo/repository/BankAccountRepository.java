package com.example.useraccount.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.useraccount.demo.entity.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {


	List<BankAccount> findByBankAccountCountry(String country);


}