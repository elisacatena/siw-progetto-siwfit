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

	// @GetMapping("/user/prenota/{id}")
	// public String getCorsiPrenotati( @PathVariable("id") Long id, Model model) {
	// Long n = (long) 2;
	// List<Corso> prenotati = this.userService.findAllCorsiPrenotati(n);
	// prenotati.add(this.corsoService.findById(id));
	// model.addAttribute("prenotati", prenotati);
	// return "categoria.html";
	// }


	@GetMapping("/user/corsi_prenotati/{username}")
	public String getCorsiPrenotati( @PathVariable("username") String username, Model model) {
		//List<Corso> prenotati = this.userService.findAllCorsiPrenotati("u1");
		//prenotati.add(this.corsoService.findById());
		User user = this.userService.findByUsername(username).get(0);
		model.addAttribute("user", user);
		return "/user/corsi_prenotati.html";
	}

	@GetMapping("/user/homeuser")
	public String getHomeUser(Model model) {
		User user = this.userService.findByUsername("u1").get(0);
		model.addAttribute("user",user);
		return "homeUser.html";
	}

}