package com.example.useraccount.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.ToString;

@Entity
@Table(name = "USERS")
@ToString
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int id;
	
	@Column(name = "MEMBER_ID")
	private String memberId;
	
	@Column(name = "MEMBER_NAME")
	private String memberName;
	
	@Column(name = "KYC_LEVEL")
	private String kycLevel;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	
	@Column(name = "MOBILE_NO_VERIFIED")
	private String mobileNoVerified;
	
	@Column(name = "CREATED_DATE")
	private String createdDate;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MY_USER_ID")
	@JsonManagedReference
	 @ToString.Exclude
	private List<BankAccount> bankAccounts;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "ACCOUNT_ID")
//	@JsonManagedReference
//	 @ToString.Exclude
//	private List<BankAccount> bankAccounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}



}
