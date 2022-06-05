package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Categoria;
import com.example.demo.model.User;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.CredenzialiService;
import com.example.demo.validator.CategoriaValidator;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private CategoriaValidator categoriaValidator;
	
	@Autowired
	private CredenzialiService credenzialiService;
	
	@GetMapping("/user/categorie")
	public String getCategorie(Model model) {
		List<Categoria> categorie = categoriaService.findAll();
		model.addAttribute("categorie", categorie);
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = credenzialiService.getCredenziali(userDetails.getUsername()).getUser();
		model.addAttribute("user",user);
		return "user/categorie.html";
	}


}
