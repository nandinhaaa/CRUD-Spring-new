package br.edu.ifsuldeminas.mach.webii.crudmanager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Curriculo;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Projeto;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.CurriculoRepository;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.ProjetoRepository;

@Component // tratar como componente assim que o sistema inicializa
@Transactional // operações dentro do DB -> inicilizar/finalizar as transações
public class InitializeDataBase implements CommandLineRunner {

	@Autowired
	private ProjetoRepository projetoRepository;
	@Autowired
	private CurriculoRepository curriculoRepository;

	@Override
	public void run(String... args) throws Exception {

		Curriculo curriculo1 = new Curriculo();
		curriculo1.setName("Maria");
		curriculo1.setIdade(21);
		curriculo1.setEmail("maria@example.com");
		curriculo1.setGender("F");
		curriculo1.setLinguagem("Java");
		curriculo1.setRemoto(true);

		Curriculo curriculo2 = new Curriculo();
		curriculo2.setName("Luis");
		curriculo2.setIdade(33);
		curriculo2.setEmail("luis@example.com");
		curriculo2.setGender("M");
		curriculo2.setLinguagem("Kotlin");
		curriculo2.setRemoto(true);

		curriculoRepository.save(curriculo1);

		curriculoRepository.save(curriculo2);

		Projeto crud = new Projeto();
		crud.setName("Crud Spring");
		crud.setComplexidade("avançado");
		crud.setDescricao("Adicionar funcionalidades no CRUD");
		crud.getCurriculos().add(curriculo1);

		projetoRepository.save(crud);

	}

}