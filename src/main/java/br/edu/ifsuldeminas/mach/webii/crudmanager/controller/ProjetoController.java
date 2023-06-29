package br.edu.ifsuldeminas.mach.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Curriculo;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Projeto;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.CurriculoRepository;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.ProjetoRepository;

@Controller
public class ProjetoController {

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private CurriculoRepository curriculoRepository;

	@GetMapping("/projetos")
	public String projetos(Model model) {
		List<Projeto> projetos = projetoRepository.findAll();
		model.addAttribute("projetos", projetos);
		return "projeto";
	}

	@GetMapping("/projetos/form")
	public String curriculoForm(@ModelAttribute("projeto") Projeto projeto, Model model) {
		List<Curriculo> curriculos = curriculoRepository.findAll();
		model.addAttribute("curriculos", curriculos);
		return "projeto_form";
	}

	@PostMapping("/projetos/new")
	public String userNew(@ModelAttribute("projeto") Projeto projeto) {
		List<Curriculo> selectedCurriculos = projeto.getCurriculos();
		List<Curriculo> curriculos = curriculoRepository.findAllById(selectedCurriculos.stream().map(Curriculo::getId).collect(Collectors.toList()));
		projeto.setCurriculos(curriculos);

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

	@GetMapping("/projetos/delete/{id}")
	public String projetoDelete(@PathVariable("id") Integer id) {
		Optional<Projeto> pProjeto = projetoRepository.findById(id);

		if (pProjeto.isPresent()) {
			Projeto projeto = pProjeto.get();
			projetoRepository.delete(projeto);
		} else {
			// Projeto não encontrado, adicione aqui a lógica para lidar com essa situação
			// Por exemplo, você pode lançar uma exceção, redirecionar para uma página de
			// erro, etc.
		}

		return "redirect:/projetos";
	}

}