package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.TrainerService;
import com.example.demo.validator.TrainerValidator;

@Controller
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private TrainerValidator trainerValidator;

}
