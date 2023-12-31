package com.example.useraccount.demo.controller;


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

import com.example.useraccount.demo.dto.MemberDto;
import com.example.useraccount.demo.entity.Member;
import com.example.useraccount.demo.service.MemberService;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RestController

public class MemberController {

	@Autowired
	private MemberService memberService;


	@PostMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Member> saveMembers(@RequestBody MemberDto memDto) {

		Member persistedEmp = memberService.save(memDto);

		return new ResponseEntity<>(persistedEmp, HttpStatus.CREATED);
	}

	@GetMapping(value = "/members/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Member>> getBankAccountsByMemberId(@PathVariable final String memberId) {

		List<Member> persistedEmp = memberService.getById(memberId);

		return new ResponseEntity<>(persistedEmp, HttpStatus.OK);
	}
	
	@GetMapping("/get/members")  
	private List<Member> getAllMember()   
	{  
	return memberService.getAllMembers();  
	}   

	@DeleteMapping("/delete/member/{memberid}")  
	private void deletemember(@PathVariable("memberid") int memberid)   
	{  
	memberService.delete(memberid);  
	}  
}
