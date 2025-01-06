package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.java.service.TestService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TestController {

	private final TestService testService;
	
	@GetMapping("/test")
	public String test(Model model, @RequestParam(name="txt", required = false) String txt) {
		model.addAttribute("result", testService.findList(txt));
		return "test";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("txt") String txt) {
		testService.save(txt);
		return "redirect:/test";
	}
	
	@PostMapping("/edit")
	public String edit(@RequestParam("txt2") String txt, @RequestParam("no") int no) {
		testService.edit(txt, no);
		return "redirect:/test";
	}
	
	@PostMapping("/del")
	public String del(@RequestParam("no") int no) {
		testService.del(no);
		return "redirect:/test";
	}
	
}
