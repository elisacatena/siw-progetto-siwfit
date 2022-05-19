package com.example.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.model.Trainer;
import com.example.demo.service.TrainerService;

@Component
public class TrainerValidator implements Validator{

	@Autowired
	private TrainerService trainerService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Trainer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}

}
