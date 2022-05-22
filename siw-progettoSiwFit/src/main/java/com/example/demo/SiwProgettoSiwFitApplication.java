package com.example.demo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Categoria;
import com.example.demo.model.Corso;
import com.example.demo.model.Trainer;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.repository.TrainerRepository;


@SpringBootApplication
public class SiwProgettoSiwFitApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository cr;
	@Autowired
	private TrainerRepository tr;
	@Autowired
	private CorsoRepository cor;
	
	public static void main(String[] args) {
		SpringApplication.run(SiwProgettoSiwFitApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Trainer t = new Trainer();
		
	 	Categoria c1 = new Categoria();
		Categoria c2 = new Categoria();
		
		c1.setNome("cat1");
		c2.setNome("cat2");
		
		
		Corso co1 = new Corso();
		Corso co2 = new Corso();
		
		co1.setNome("corso1");
		co2.setNome("corso2");
		
		co1.setData("2022");
		co2.setData("2023");
		
		Corso co3 = new Corso();
		Corso co4 = new Corso();
		
		co3.setNome("corso3");
		co4.setNome("corso4");
		
		co3.setData("2022");
		co4.setData("2023");
		
//		co1.setCategoria(c1);
//		co2.setCategoria(c2);
		
		List<Corso> corsi = new LinkedList<Corso>();
		corsi.add(co1);
		corsi.add(co2);
		
		List<Corso> corsi2 = new LinkedList<Corso>();
		corsi2.add(co3);
		corsi2.add(co4);
		
		c1.setCorsi(corsi);
		c2.setCorsi(corsi2);
		
		tr.save(t);
		cor.save(co1);
		cor.save(co2);
		cor.save(co3);
		cor.save(co4);
		cr.save(c1);
		cr.save(c2);
		
		
	}

}
