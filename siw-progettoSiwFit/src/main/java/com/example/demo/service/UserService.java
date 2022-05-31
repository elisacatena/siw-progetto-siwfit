package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	public User findById(Long id) {
		return this.userRepository.findById(id).get();
	}

	public boolean alreadyExists(User user) {
		return this.userRepository.existsById(user.getId());
	}

}
