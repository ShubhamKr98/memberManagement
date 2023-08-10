package com.example.useraccount.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.useraccount.demo.dto.BankAccountDto;
import com.example.useraccount.demo.dto.MemberDto;
import com.example.useraccount.demo.entity.BankAccount;
import com.example.useraccount.demo.entity.Member;
import com.example.useraccount.demo.repository.MemberRepository;


@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	public Member save(MemberDto memberDto) {

		String memberId=memberDto.getMemberId();
		String memberName = memberDto.getMemberName();
		String kycLevel = memberDto.getKycLevel();
		String mobileNo = memberDto.getMobileNo();
		String mobileNoVerified =memberDto.getMobileNoVerified();
		String createdDate = memberDto.getCreatedDate();

		Member mem = new Member();
		mem.setMemberId(memberId);
		mem.setMemberName(memberName);
		mem.setKycLevel(kycLevel);
		mem.setMobileNo(mobileNo);
		mem.setMobileNoVerified(mobileNoVerified);
		mem.setCreatedDate(createdDate);

		List<BankAccountDto> bankAccountsDto = memberDto.getAccounts();
		if (bankAccountsDto != null) {
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		
		for (BankAccountDto accDto : bankAccountsDto) {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setAccountNumber(accDto.getAccountNumber());
			bankAccount.setBankName(accDto.getBankName());
			bankAccount.setBankAccountCountry(accDto.getBankAccountCountry());
			bankAccount.setBankAccountHolder(accDto.getBankAccountHolder());

			accounts.add(bankAccount);
		}

		mem.setBankAccounts(accounts);
		}
		return memberRepository.save(mem);
	}


	public List<Member> getById(String id) {
//		return memberRepository.findById(id).get();
		return memberRepository.findByMemberId(id);
	}
	
	public List<Member> getAllMembers() {

		List<Member> members = new ArrayList<Member>();  
		memberRepository.findAll().forEach(member1 -> members.add(member1));  
		return members;  

	}
	
	public void delete(int memberid) {

		memberRepository.deleteById(memberid); 
	}


}