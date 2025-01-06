package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.domain.TestEntity;
import com.java.repository.TestEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TestController {

	private final TestEntityRepository testEntityRepository;
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("result", testEntityRepository.findAll());
		return "test";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("txt") String txt) {
		TestEntity tEntity = new TestEntity();
		tEntity.setTxt(txt);
		
		testEntityRepository.save(tEntity);
		
		return "redirect:/test";
	}
	
}
