package com.example.useraccount.demo.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.useraccount.demo.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {

	List<Member> findByMemberId(String id);

}

