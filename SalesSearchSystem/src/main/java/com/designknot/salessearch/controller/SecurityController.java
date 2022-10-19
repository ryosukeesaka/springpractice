package com.designknot.salessearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SecurityController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/sign_up")
	public String signin() {
		return "redirect:/user_list";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
}
