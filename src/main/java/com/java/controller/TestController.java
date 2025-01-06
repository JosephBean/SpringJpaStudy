package com.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.repository.TestEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {

	private final TestEntityRepository testEntityRepository;
	
	@GetMapping("/test")
	public String test() {
		return "OK";
	}
	
}
