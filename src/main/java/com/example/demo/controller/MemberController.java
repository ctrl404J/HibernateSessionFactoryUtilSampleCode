package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.MemberRepository;
import com.example.demo.entity.Member;

@RestController
public class MemberController {

	@Autowired
	MemberRepository repository;

	@GetMapping("/find")
	public List<Member> getList() {

		System.out.println("起動成功@@@@@@@@@@@@@@@@");
		return repository.findAll();

	}

}
