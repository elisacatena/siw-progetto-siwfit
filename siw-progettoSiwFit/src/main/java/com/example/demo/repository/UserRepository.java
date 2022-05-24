package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Corso;
import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT corsiPrenotati FROM User WHERE username = ?1")
	public List<Corso> findAllCorsiPrenotati(String username);

	public boolean existsByUsername(String username);
}
