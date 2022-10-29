package com.bankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

	@GetMapping(path = "hellourl")
	public ModelAndView hello(ModelAndView mv) {
		mv.setViewName("hellopage");
		mv.addObject("info", "we all are mvc champs");
		return mv;
	}
	
	@GetMapping(path = "hellourl2")
	public String hello2(Model model) {
		model.addAttribute("info", "we all are mvc champs 2");
		return "hellopage";
	}
}
