package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Corso;
import com.example.demo.repository.CorsoRepository;

@Service
public class CorsoService {

	@Autowired
	private CorsoRepository corsoRepository;

	public Corso findById(Long id) {
		return corsoRepository.findById(id).get();
	}

	public boolean alreadyExists(Corso corso) {
		return this.corsoRepository.existsById(corso.getId());
	}

	@Transactional
	public void save(Corso c) {
		this.corsoRepository.save(c);
	}
}
