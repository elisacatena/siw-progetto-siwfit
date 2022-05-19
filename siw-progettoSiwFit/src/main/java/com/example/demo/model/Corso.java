package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private LocalDateTime data;
	private String difficolta;
	private String durata;
	private String descrizione;
	private String sala;
	private int numeroMaxPersone;
	
	@ManyToOne
	private Trainer trainer;
	
	@ManyToOne
	private Categoria categoria;
	
	
	public Corso() {}

	public Corso(String nome, LocalDateTime data, String difficolta, String durata, String descrizione, String sala,
			int numeroMaxPersone, Trainer trainer, Categoria categoria) {
		this.nome = nome;
		this.data = data;
		this.difficolta = difficolta;
		this.durata = durata;
		this.descrizione = descrizione;
		this.sala = sala;
		this.numeroMaxPersone = numeroMaxPersone;
		this.trainer = trainer;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public String getDifficolta() {
		return difficolta;
	}
	public void setDifficolta(String difficolta) {
		this.difficolta = difficolta;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	
	public int getNumeroMaxPersone() {
		return numeroMaxPersone;
	}

	public void setNumeroMaxPersone(int numeroMaxPersone) {
		this.numeroMaxPersone = numeroMaxPersone;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return this.getData().hashCode() + this.getNome().hashCode() + 31;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return this.getNome().equals(other.getNome()) && this.getData() == other.getData();
	}	
	
}
