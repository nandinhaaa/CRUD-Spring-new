package br.edu.ifsuldeminas.mach.webii.crudmanager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projetos")
public class Projeto {

	@Id // chave primaria da nossa tabela
	@GeneratedValue(strategy = GenerationType.AUTO) // gerar uma chave auto incremento
	private Integer id;
	private String name;
	private String complexidade;
	private String descricao;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Curriculo> curriculos = new ArrayList<>();


	public Projeto() {
		setName("");
		setComplexidade("");
		setDescricao("");
	}

	public Projeto(Integer id) {
		this.id = id;
		setName("");
		setComplexidade("");
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

	public String getComplexidade() {
		return complexidade;
	}

	public void setComplexidade(String email) {
		this.complexidade = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	} // criar os obj vazios

	public List<Curriculo> getCurriculos() {
		return curriculos;
	}

	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}



}