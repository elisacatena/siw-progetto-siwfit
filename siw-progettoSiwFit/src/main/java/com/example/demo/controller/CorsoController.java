package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Corso;
import com.example.demo.service.CorsoService;
import com.example.demo.service.UserService;
import com.example.demo.validator.CorsoValidator;

@Controller
public class CorsoController {
	
	@Autowired
	private CorsoService corsoService;
	
	@Autowired
	private CorsoValidator corsoValidator;
	
	@Autowired
	private UserService userService;
	
//	@GetMapping("/corsi")
//	public String getCorsi(Model model) {
//		List<Corso> corsi = corsoService.findAll();
//		model.addAttribute("corsi", corsi);
//		return "corsi.html";
//	}

	/* id è del corso.
	 * Il metodo resituisce un corso tramite il suo id.
	 */
	@GetMapping("/user/corso/{id}")
	public String getCorso(@PathVariable("id")Long id, Model model) {
		Corso corso = corsoService.findById(id);
		model.addAttribute("corso", corso);
		return "corso.html";
	}
	
	@GetMapping("/user/prenota/{id}")
	public String getCorsiPrenotati( @PathVariable("id") Long id, Model model) {
		List<Corso> prenotati = this.userService.findAllCorsiPrenotati("u1");
		prenotati.add(this.corsoService.findById(id));
		model.addAttribute("prenotati", prenotati);
		return "homeUser.html";
	}
	


}
