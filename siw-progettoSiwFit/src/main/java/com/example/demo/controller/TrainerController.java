package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.User;
import com.example.demo.service.CredenzialiService;
import com.example.demo.service.TrainerService;
import com.example.demo.validator.TrainerValidator;

@Controller
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private TrainerValidator trainerValidator;
	
	@Autowired
	private CredenzialiService credenzialiService;

	@GetMapping("/user/trainers")
	public String getAllTrainers(Model model) {
		model.addAttribute("trainers", this.trainerService.findAll());	
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = credenzialiService.getCredenziali(userDetails.getUsername()).getUser();
    	model.addAttribute("user", user);
		return "user/trainers.html";
	}
	
	@GetMapping("/user/trainer/{id}")
	public String getTrainer(@PathVariable("id") Long id, Model model) {
		model.addAttribute("trainer", this.trainerService.findById(id));	
		return "user/trainer.html";
	}
}
