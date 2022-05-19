package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.CorsoService;
import com.example.demo.validator.CorsoValidator;

@Controller
public class CorsoController {
	
	@Autowired
	private CorsoService corsoService;
	
	@Autowired
	private CorsoValidator corsoValidator;

}
