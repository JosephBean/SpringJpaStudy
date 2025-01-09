package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.domain.Ex1;
import com.java.repository.Ex1Repository;

@Controller
public class Ex1Controller {

	@Autowired
	private Ex1Repository ex1Repository;
	
	@GetMapping("/")
	public String home(
			@RequestParam(name = "accept", required = false) String accept,
			Model model) {
		List<Ex1> ex1s = null;
		if(accept == null) accept = "2";
		if(accept.equals("0")) {
			ex1s = ex1Repository.findByAccept(false);
		} else if(accept.equals("1")) {
			ex1s = ex1Repository.findByAccept(true);
		} else {
			ex1s = ex1Repository.findAll();
		}
		model.addAttribute("result", ex1s);
		return "list";
	}
	
	@GetMapping("/input")
	public String input() {
		return "input";
	}
	
	@PostMapping("/input")
	public String input(
			@RequestParam("title") String title, 
			@RequestParam("content") String content) {
		Ex1 ex1 = Ex1.builder()
					.title(title).content(content)
					.build();
		ex1Repository.save(ex1);
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public String detail(
			@RequestParam(name = "no", required = false) Integer no,
			Model model) {
		if(no == null) return "redirect:/";
		Ex1 ex1 = ex1Repository.findById(no).get();
		model.addAttribute("result", ex1);
		return "detail";
	}
	
	@PostMapping("/edit")
	public String edit(
			@RequestParam(name = "no", required = false) Integer no,
			@RequestParam("title") String title, 
			@RequestParam("content") String content
			) {
		if(no == null) return "redirect:/";
		Ex1 ex1 = ex1Repository.findById(no).orElseThrow();
		ex1.setTitle(title);
		ex1.setContent(content);
		return "redirect:/detail?no=" + ex1Repository.save(ex1).getNo();
	}
	
	@GetMapping("/accept")
	public String accept(
			@RequestParam(name = "no", required = false) Integer no,
			@RequestParam(name = "accept", required = false) String accept
			) {
		if(no == null || accept == null) {
			return "redirect:/";
		}
		boolean type = accept.equals("0") ? true : false;
		Ex1 ex1 = ex1Repository.findById(no).orElseThrow();
		ex1.setAccept(type);
		return "redirect:/detail?no=" + ex1Repository.save(ex1).getNo();
	}
	
	@ResponseBody
	@GetMapping("/ex1")
	public String ex1() {
//		List<Ex1> ex1s = ex1Repository.findAll();
//		System.out.println(ex1s.size());
//		ex1s.forEach(ex1 -> {
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
//			ex1Repository.delete(ex1);
//		});
		return "OK";
	}
	
}
