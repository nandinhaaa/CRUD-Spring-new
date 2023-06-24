package br.edu.ifsuldeminas.mach.webii.crudmanager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Curriculo;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Projeto;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.CurriculoRepository;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.ProjetoRepository;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.UserRepository;

@Component // tratar como componente assim que o sistema inicializa
@Transactional // operações dentro do DB -> inicilizar/finalizar as transações
public class InitializeDataBase implements CommandLineRunner {

	@Autowired //faz a mágica user é uma interface mas eu quero um obj 
	private UserRepository userRepository;
	@Autowired
	private ProjetoRepository projetoRepository;
	@Autowired
	private CurriculoRepository curriculoRepository;

	@Override
	public void run(String... args) throws Exception {
		User nanda = new User();
		nanda.setName("Nanda");
		nanda.setEmail("nanda@gmail.com");
		nanda.setGender("F");
		nanda.setEndereco("Rua A");

		User emerson = new User();
		emerson.setName("Emerson");
		emerson.setEmail("Emerson@gmail.com");
		emerson.setGender("M");
		emerson.setEndereco("Rua C");

		User le = new User();
		le.setName("Le");
		le.setEmail("Le@gmail.com");
		le.setGender("F");
		le.setEndereco("Rua B");
		
		Projeto crud = new Projeto ();
		crud.setName("Crud Spring");
		crud.setEmail("Crud@gmail.com");
		crud.setDescricao("Adicionar funcionalidades no CRUD");
		
		Curriculo curriculo1 = new Curriculo();
		curriculo1.setName("Nome do currículo");
		curriculo1.setIdade(21);
		curriculo1.setEmail("email@example.com");
		curriculo1.setGender("M");
		curriculo1.setLinguagem("Java");
		curriculo1.setRemoto(true);

		
		
		userRepository.save(nanda);
		userRepository.save(emerson);
		userRepository.save(le);
		projetoRepository.save(crud);
		curriculoRepository.save(curriculo1);
		
		
		List<User> users = userRepository.findAll(); // disparou um select 
		
		for (User user : users) {
			System.err.println(user.getName());
			System.err.println(user.getEmail());
			System.err.println(user.getGender());
			System.err.println(user.getEndereco());
			
		}
		
		
		List<Projeto> projetos = projetoRepository.findAll();
		
		for (Projeto projeto : projetos) {
		    System.err.println(projeto.getName());
		    System.err.println(projeto.getEmail());
		    System.err.println(projeto.getDescricao());
		}
		
		List<Curriculo> curriculos = curriculoRepository.findAll();
		for (Curriculo curriculo : curriculos) {
		    System.err.println(curriculo.getName());
		    System.err.println(curriculo.getEmail());
		    System.err.println(curriculo.getGender());
		    System.err.println(curriculo.getLinguagem());
		    System.err.println(curriculo.getRemoto());
		}

	}

}