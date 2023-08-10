package com.example.useraccount.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useraccount.demo.dto.BankAccountDto;
import com.example.useraccount.demo.dto.MemberDto;
import com.example.useraccount.demo.entity.BankAccount;
import com.example.useraccount.demo.repository.BankAccountRepository;


@Service
public class BankAccountService  {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	public List<BankAccount> getAllBanks() {

		List<BankAccount> banks = new ArrayList<BankAccount>(); 
		bankAccountRepository.findAll().forEach(member1 -> banks.add(member1));  
	

		return banks;  

	}

	public void delete(int bankId) {

		bankAccountRepository.deleteById(bankId); 
	}

	public BankAccount save(BankAccountDto bankAccountDto) {
		
		String accountNumber = bankAccountDto.getAccountNumber();
		String bankName =bankAccountDto.getBankName();
		String bankAccountCountry=bankAccountDto.getBankAccountCountry();
		String bankAccountHolder=bankAccountDto.getBankAccountHolder();
		

		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNumber(accountNumber);
		bankAccount.setBankName(bankName);
		bankAccount.setBankAccountCountry(bankAccountCountry);
		bankAccount.setBankAccountHolder(bankAccountHolder);

		return bankAccountRepository.save(bankAccount);
	}

	public ArrayList<MemberDto> getMemberByBranch(String country) {
		// TODO Auto-generated method stub
		System.out.println("Value---->"+bankAccountRepository.findByBankAccountCountry(country).toString());
		
//		ArrayList<BankAccount>bankAccounts= new ArrayList<BankAccount>;
		
		List<BankAccount> bankAccounts =  bankAccountRepository.findByBankAccountCountry(country);
	
		System.out.println("User---->"+bankAccounts.get(0).getUser().toString());
//		String s=bankAccountRepository.findByBranch(country).getUser().getFirstName();
//		Member member=bankAccount.getUser();
		ArrayList<MemberDto>memberDtos=new ArrayList<MemberDto>();
		
		String memberId="";
		for (BankAccount bankAccount:bankAccounts) {
//			Member mem=new Member();
			MemberDto mem = new MemberDto();
		
			if( !(bankAccount.getUser().getMemberId().equals(memberId)) )
			{
			mem.setMemberId(bankAccount.getUser().getMemberId());
			mem.setMemberName(bankAccount.getUser().getMemberName());
			memberId=mem.getMemberId();
			System.out.println("memberId-->"+memberId);
			mem.setKycLevel(bankAccount.getUser().getKycLevel());
			mem.setMobileNo(bankAccount.getUser().getMobileNo());
			mem.setMobileNoVerified(bankAccount.getUser().getMobileNoVerified());
			mem.setCreatedDate(bankAccount.getUser().getCreatedDate());
			
			memberDtos.add(mem);

			}
		}
		return memberDtos;
//		return null;
	}


}