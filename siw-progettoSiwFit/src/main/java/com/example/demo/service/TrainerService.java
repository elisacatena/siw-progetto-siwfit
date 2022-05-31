package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;
import com.example.demo.model.Trainer;
import com.example.demo.repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;

	public boolean alreadyExists(Trainer trainer) {
		return this.trainerRepository.existsById(trainer.getId());
	}

	public List<Trainer> findAll() {
		List<Trainer> trainers = new ArrayList<Trainer>();
		for (Trainer trainer : trainerRepository.findAll()) {
			trainers.add(trainer);
		}
		return trainers;
	}

	public Trainer findById(Long id) {
		return this.trainerRepository.findById(id).get();
	}
}
