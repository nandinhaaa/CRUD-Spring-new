package br.edu.ifsuldeminas.mach.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Projeto;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.ProjetoRepository;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.UserRepository;

@Controller
public class ProjetoController {

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/projetos")
	public String projetos(Model model) {
		List<Projeto> projetos = projetoRepository.findAll();
		model.addAttribute("projetos", projetos);
		return "projeto";
	}

	@GetMapping("/projetos/form")
	public String userForm(@ModelAttribute("projeto") Projeto projeto, Model model) {
	    List<User> usuarios = userRepository.findAll();
	    model.addAttribute("usuarios", usuarios);
	    return "projeto_form";
	}


	@PostMapping("/projetos/new")
	public String userNew(@ModelAttribute("projeto") Projeto projeto) {
		projetoRepository.save(projeto);
		return "redirect:/projetos";
	}

	@GetMapping("/projetos/update/{id}")
	public String ProjetoUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Projeto> pProjeto = projetoRepository.findById(id);
		if (!pProjeto.isPresent()) {
			// Gerar erro
		}
		Projeto projeto = pProjeto.get();
		model.addAttribute("projeto", projeto);
		return "projeto_form";
	}

	@GetMapping("/projetos/add-usuario/{projetoId}/{userId}")
	public String adicionarUsuarioAoProjeto(@PathVariable("projetoId") Integer projetoId,
	        @PathVariable("userId") Integer userId) {
	    Optional<Projeto> projetoOptional = projetoRepository.findById(projetoId);
	    Optional<User> userOptional = userRepository.findById(userId);

	    if (projetoOptional.isPresent() && userOptional.isPresent()) {
	        Projeto projeto = projetoOptional.get();
	        User user = userOptional.get();

	        List<User> users = projeto.getUsers();
	        users.add(user);
	        projeto.setUsers(users);

	        user.setProjeto(projeto); // Atualiza o projeto do usuário

	        projetoRepository.save(projeto);
	        userRepository.save(user);
	    }

	    return "redirect:/projetos/update/" + projetoId;
	}
	
	@GetMapping("/projetos/delete/{id}")
	public String projetoDelete(@PathVariable("id") Integer id) {
	    Optional<Projeto> pProjeto = projetoRepository.findById(id);

	    if (pProjeto.isPresent()) {
	        Projeto projeto = pProjeto.get();
	        projetoRepository.delete(projeto);
	    } else {
	        // Projeto não encontrado, adicione aqui a lógica para lidar com essa situação
	        // Por exemplo, você pode lançar uma exceção, redirecionar para uma página de erro, etc.
	    }

	    return "redirect:/projetos";
	}




}