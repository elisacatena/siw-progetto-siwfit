package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long> {

}
