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
		curriculo1.setName("Nome do currículo");
		curriculo1.setIdade(21);
		curriculo1.setEmail("email@example.com");
		curriculo1.setGender("M");
		curriculo1.setLinguagem("Java");
		curriculo1.setRemoto(true);

		curriculoRepository.save(curriculo1);
		
		Projeto crud = new Projeto ();
		crud.setName("Crud Spring");
		crud.setComplexidade("avançado");
		crud.setDescricao("Adicionar funcionalidades no CRUD");
		crud.getCurriculos().add(curriculo1);
		
		projetoRepository.save(crud);
	
	}

}