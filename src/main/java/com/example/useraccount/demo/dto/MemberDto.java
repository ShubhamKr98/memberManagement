package com.example.useraccount.demo.dto;


import java.util.List;

public class MemberDto {
	
	private String memberId;
	
	private String memberName;
	
	private String kycLevel;
	
	private String mobileNo;
	
	private String mobileNoVerified;
	
	private String createdDate;
	
	private List<BankAccountDto> accounts;

	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getKycLevel() {
		return kycLevel;
	}

	public void setKycLevel(String kycLevel) {
		this.kycLevel = kycLevel;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMobileNoVerified() {
		return mobileNoVerified;
	}

	public void setMobileNoVerified(String mobileNoVerified) {
		this.mobileNoVerified = mobileNoVerified;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<BankAccountDto> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccountDto> accounts) {
		this.accounts = accounts;
	}

	

}
