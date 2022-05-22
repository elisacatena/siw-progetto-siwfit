package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
import com.example.demo.validator.CategoriaValidator;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private CategoriaValidator categoriaValidator;
	
	@GetMapping("/categorie")
	public String getCategorie(Model model) {
		List<Categoria> categorie = categoriaService.findAll();
		model.addAttribute("categorie", categorie);
		return "categorie.html";
	}

	@GetMapping("/categoria/{id}")
	public String getCategoria(@PathVariable("id")Long id, Model model) {
		Categoria categoria = categoriaService.findById(id);
		model.addAttribute("categoria", categoria);
		return "categoria.html";
	}
	
	/*ATTENZIONE, MODIFICARE CON I RELATIVI LOGIN*/
	
	@GetMapping("/homeuser")
	public String getCategoria() {
		return "homeUser.html";
	}
	
	/*!!!!!!!!!!!!------------!!!!!!!*/
}
