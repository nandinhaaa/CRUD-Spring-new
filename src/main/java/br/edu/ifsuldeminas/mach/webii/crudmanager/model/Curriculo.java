package br.edu.ifsuldeminas.mach.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curriculos")
public class Curriculo {

	@Id // chave primaria da nossa tabela
	@GeneratedValue(strategy = GenerationType.AUTO) // gerar uma chave auto incremento
	private Integer id;
	private String name;
	private Integer idade;
	private String email;
	private String gender;
	private String linguagem;
	private Boolean remoto;

	public Curriculo() {
		setName("");
		setIdade(0);
		setEmail("");
		setGender("");
		setLinguagem("");
		setRemoto(false);
	}

	public Curriculo(Integer id) {
		this.id = id;
		setName("");
		setIdade(0);
		setEmail("");
		setGender("");
		setLinguagem("");
		setRemoto(false);
	} // criar os obj vazios

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public Boolean getRemoto() {
		return remoto;
	}

	public void setRemoto(Boolean remoto) {
		this.remoto = remoto;
	}

}
