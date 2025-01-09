package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.domain.Ex1;
import com.java.repository.Ex1Repository;

@RestController
public class Ex1Controller {

	@Autowired
	private Ex1Repository ex1Repository;
	
	@GetMapping("/ex1")
	public String ex1() {
		List<Ex1> ex1s = ex1Repository.findAll();
		System.out.println(ex1s.size());
		ex1s.forEach(ex1 -> {
//			Ex1 e1 = Ex1.builder()
//					.no(ex1.getNo())
//					.content(ex1.getContent())
//					.accept(ex1.isAccept())
//					.regDate(ex1.getRegDate())
//					.title("수정").build();
//			System.out.println(e1);
//			ex1 = e1;
//			ex1 = ex1Repository.save(e1);
//			ex1.setTitle("수정정정");
//			ex1 = ex1Repository.save(ex1);
//			System.out.println(ex1.getTitle());
			ex1Repository.delete(ex1);
		});
		
		return "OK";
	}
	
}
