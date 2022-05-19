package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;
}
