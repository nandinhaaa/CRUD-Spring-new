package br.edu.ifsuldeminas.mach.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mach.webii.crudmanager.model.Curriculo;
import br.edu.ifsuldeminas.mach.webii.crudmanager.model.dao.CurriculoRepository;

@Controller // receber e tratar requisições
public class CurriculoController {

	@Autowired // Já sabe trabalhar com os dados
	private CurriculoRepository curriculoRepository;

	@GetMapping("/curriculos") // req chama e so vai ser atendida se for do tipo Get e o Request Recebe
			
	public String curriculos(Model model) { // framework Model

		List<Curriculo> curriculos = curriculoRepository.findAll();
		model.addAttribute("curriculos", curriculos);

		return "curriculo"; // página que vai ser redirecionada
	}

	@GetMapping("/curriculos/form")
	public String curriculoForm(@ModelAttribute("curriculo") Curriculo curriculo) {
	    return "curriculo_form";
	}


	@PostMapping("/curriculos/new")
	public String curriculoNew(@Valid @ModelAttribute("curriculo") Curriculo curriculo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "curriculo_form";
		}
		curriculoRepository.save(curriculo);

		return "redirect:/curriculos"; // usuario n sabe que isso foi feito é um requisicao interna
	}

	@GetMapping("/curriculos/update/{id}")
	public String curriculoUpdate(@PathVariable("id") Integer id, Model model) { // variavel cujo o valor está inserido
																					// na
		// URL

		Optional<Curriculo> optCurriculo = curriculoRepository.findById(id); // Optional usado pra evitar erros
																				// (verificar se o obj n é
		// nulo)

		if (!optCurriculo.isPresent()) {
			// Gerar erro
		}

		Curriculo curriculo = optCurriculo.get();

		model.addAttribute("curriculo", curriculo);

		return "curriculo_form";
	}

	@GetMapping("/curriculos/delete/{id}")
	public String curriculoDelete(@PathVariable("id") Integer id) {

		Optional<Curriculo> optCurriculo = curriculoRepository.findById(id);

		if (!optCurriculo.isPresent()) { // recupera no banco de dados quando clica em alterar
			// Gerar erro
		}

		Curriculo curriculo = optCurriculo.get();

		curriculoRepository.delete(curriculo);

		return "redirect:/curriculos";
	}
}
