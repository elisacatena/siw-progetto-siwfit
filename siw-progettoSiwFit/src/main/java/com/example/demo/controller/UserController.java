package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.User;
import com.example.demo.service.CorsoService;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private CorsoService corsoService;
	

	@GetMapping("/user/corsi_prenotati/{username}")
	public String getCorsiPrenotati(@PathVariable("username") String username, Model model) {
		//model.addAttribute("corsiPrenotati", this.userService.findByUsername(username).getCorsiPrenotati());
		model.addAttribute("user", this.userService.findByUsername(username));
		return "/user/corsi_prenotati.html";
	}
	
	@GetMapping("/user/{id}/homeuser")
	public String getHomeUser(@PathVariable("id") Long id, Model model) {
		User user = this.userService.findById(id);
		model.addAttribute("user", user);
		return "user/homeUser.html";
	}
	
}
