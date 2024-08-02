package it.astrignano.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.astrignano.pizzeria.model.IngredienteModel;
import it.astrignano.pizzeria.model.OffertaModel;
import it.astrignano.pizzeria.model.PizzaModel;
import it.astrignano.pizzeria.repositoiry.IngredienteRepository;
import it.astrignano.pizzeria.repositoiry.OffertaRepository;
import it.astrignano.pizzeria.repositoiry.PizzaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredienti")
public class IngrController {
	
	@Autowired
	private IngredienteRepository ingreRepo;
	
//-----INDEX + CREATE----
	@GetMapping("")
	public String ingrList(Model model, IngredienteModel ingrediente) {
		
		model.addAttribute("ingredienti", ingreRepo.findAll());
		model.addAttribute("ingrediente", new IngredienteModel());
		
		return"/ingredienti/lista";
	}
	
	@PostMapping("/create")
	public String storeIngr(@Valid @ModelAttribute ("ingrediente") IngredienteModel ingrediente, 
			Model model, BindingResult bindingResult ) {
		
		if(bindingResult.hasErrors()) {
			return "/ingredienti/lista";
		}
		
		ingreRepo.save(ingrediente);
		
		return "redirect:/ingredienti";
	}

//-----EDIT-----
	@GetMapping("/edit/{id}")
	public String editIngr(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("ingrEdit", ingreRepo.findById(id).get());
		return"/ingredienti/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String storeEditIngr(
		@Valid @ModelAttribute("ingrEdit") IngredienteModel ingrEdit,
		BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()){
			return "/ingredienti/edit";
		}
		
		ingreRepo.save(ingrEdit);
		
		return"redirect:/ingredienti";
	}
	
//------DELETE--------
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable ("id") Integer id) {
		
		ingreRepo.deleteById(id);
		return"redirect:/ingredienti";
	}
	
}
