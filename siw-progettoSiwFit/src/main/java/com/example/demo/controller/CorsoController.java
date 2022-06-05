package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Corso;
import com.example.demo.model.User;
import com.example.demo.service.CorsoService;
import com.example.demo.service.CredenzialiService;
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
	
	@Autowired
	private CredenzialiService credenzialiService;

	/* id è del corso.
	 * Il metodo resituisce un corso tramite il suo id.
	 */
	@GetMapping("/user/corso/{id}")
	public String getCorso(@PathVariable("id")Long id, Model model) {
		Corso corso = corsoService.findById(id);
		model.addAttribute("corso", corso);
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = credenzialiService.getCredenziali(userDetails.getUsername()).getUser();
    	model.addAttribute("user", user);
		Boolean prenotazione = (user.getCorsiPrenotati().contains(corso)) || (corso.getIscritti().size() >= corso.getNumeroMaxPersone());
		Boolean cancellazione = (user.getCorsiPrenotati().contains(corso));
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("cancellazione", cancellazione);
		return "user/corso.html";
	}

	@GetMapping("/user/prenota/{id}") //id del corso
	public String getPrenota(@PathVariable("id") Long id, Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = credenzialiService.getCredenziali(userDetails.getUsername()).getUser();
		Corso corso = this.corsoService.findById(id);
		user.getCorsiPrenotati().add(corso);
		this.userService.save(user);
		corso.getIscritti().add(user);
		this.corsoService.save(corso);
		model.addAttribute("user",user);
		model.addAttribute("corso", corso);
		Boolean prenotazione = (user.getCorsiPrenotati().contains(corso)) || (corso.getIscritti().size() >= corso.getNumeroMaxPersone());
		Boolean cancellazione = (user.getCorsiPrenotati().contains(corso));
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("cancellazione", cancellazione);
		return "user/corso";
	}

	@GetMapping("/user/delete_corsoPrenotato/{id}")
	public String deleteCorsoPrenotatoFromCorso(@PathVariable("id")Long id, Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = credenzialiService.getCredenziali(userDetails.getUsername()).getUser();
    	Corso corso = this.corsoService.findById(id);
		user.getCorsiPrenotati().remove(corso);
		corso.getIscritti().remove(user);
		this.corsoService.save(corso);
		this.userService.save(user);
		
		Boolean prenotazione = (user.getCorsiPrenotati().contains(corso)) || (corso.getIscritti().size() >= corso.getNumeroMaxPersone());
		Boolean cancellazione = (user.getCorsiPrenotati().contains(corso));
		model.addAttribute("prenotazione", prenotazione);
		model.addAttribute("cancellazione", cancellazione);
		model.addAttribute("user", user);
		model.addAttribute("corso", corso);
		return "user/corso.html";
	}


}