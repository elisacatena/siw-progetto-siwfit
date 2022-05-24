package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Utente")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cognome;
	
	@Column(nullable = false)
	@NotBlank
	private String username;
	
	private String password;
	
	@ManyToMany(mappedBy = "iscritti")
	private List<Corso> corsiPrenotati;
	
	public User() {} 
	
	public User(String nome, String cognome, String username, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Corso> getCorsiPrenotati() {
		return corsiPrenotati;
	}

	public void setCorsiPrenotati(List<Corso> corsiPrenotati) {
		this.corsiPrenotati = corsiPrenotati;
	}

	@Override
	public int hashCode() {
		return this.getUsername().hashCode() + 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return this.getUsername().equals(other.getUsername());
	}
	

}
