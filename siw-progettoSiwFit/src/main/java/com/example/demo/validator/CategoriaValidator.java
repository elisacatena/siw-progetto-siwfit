package com.example.demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;

@Component
public class CategoriaValidator implements Validator{

	@Autowired
	private CategoriaService categoriaService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Categoria.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}

}
