package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Corso;
import com.example.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT corsiPrenotati FROM User WHERE username = ?1")
	public List<Corso> findAllCorsiPrenotati(String username);

	public boolean existsByUsername(String username);
	
	public List<User> findByUsername(String username);
}
