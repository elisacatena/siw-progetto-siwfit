package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import com.example.demo.model.Corso;
import com.example.demo.model.User;
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

	/* id è del corso.
	 * Il metodo resituisce un corso tramite il suo id.
	 */
	@GetMapping("/user/corso/{id}")
	public String getCorso(@PathVariable("id")Long id, Model model) {

		Corso corso = corsoService.findById(id);
		model.addAttribute("corso", corso);
		User user = this.userService.findByUsername("u1").get(0);
		Boolean condition = (user.getCorsiPrenotati().contains(corso)) || (corso.getIscritti().size() >= corso.getNumeroMaxPersone());
		model.addAttribute("condition", condition);
		return "user/corso.html";
	}

	@GetMapping("/user/prenota/{id}") //id del corso
	public String getPrenota( @PathVariable("id") Long id, Model model) {

		User user = this.userService.findByUsername("u1").get(0);

		Corso c = this.corsoService.findById(id);
		user.getCorsiPrenotati().add(c);
		this.userService.save(user);

		c.getIscritti().add(user);
		this.corsoService.save(c);

		model.addAttribute("user",user);
		return "/user/corsi_prenotati";
	}



}