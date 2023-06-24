package br.edu.ifsuldeminas.mach.webii.crudmanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projetos")
public class Projeto {

	@Id // chave primaria da nossa tabela
	@GeneratedValue(strategy = GenerationType.AUTO) // gerar uma chave auto incremento
	private Integer id;
	private String name;
	private String email;
	private String descricao;
	
	@ManyToMany
	private List<User> users;


	public Projeto() {
		setName("");
		setEmail("");
		setDescricao("");
	}

	public Projeto(Integer id) {
		this.id = id;
		setName("");
		setEmail("");
		setDescricao("");
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	} // criar os obj vazios

	public List<User> getUsers() {
	    return users;
	}
		
	public void setUsers(List<User> users) {
	    this.users = users;
	}

}