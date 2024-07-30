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
import it.astrignano.pizzeria.model.PizzaModel;
import it.astrignano.pizzeria.repositoiry.PizzaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pizzeria")
public class PizzaController {

	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	
	@GetMapping("/menu")
	public String pizze(Model model) {
		model.addAttribute("pizze", pizzaRepo.findAll());
		
		return "/pizzeria/index";
	}
	
	//--------READ--------
	@GetMapping("/dettaglio/{id}")
	public String dettaglioPizza(@PathVariable("id") Integer id,  Model model) {
		
		
		model.addAttribute("dettaglio", pizzaRepo.findById(id).get());
		return "/pizzeria/dettaglio";
		
	}
	
	//-------CREATE-------
	//GET
	@GetMapping("/create")
	public String create(Model model) {
		
		
		model.addAttribute("pizza", new PizzaModel());
		 
		return "/pizzeria/create";
	}
	//POST
	@PostMapping("/create")
	public String store(
			@Valid @ModelAttribute("pizza") PizzaModel pizza,
			BindingResult bindingResult, Model model)  {
		
		if(bindingResult.hasErrors()) {
			return "/pizzeria/create";
		}
		
		pizzaRepo.save(pizza);
		
		return "redirect:/pizzeria/menu";
	}
	
	//--------EDIT-------
	//GET
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("pizza", pizzaRepo.getReferenceById(id));
		
		return "/pizzeria/edit";
	}
	//POST
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("pizza") PizzaModel pizza, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()){
			return "/pizzeria/edit";
		}
		
		pizzaRepo.save(pizza);
		
		return "redirect:/pizzeria/menu";
	}

	
	//------DELETE-------
	@PostMapping("/delete/{id}")
	 public String delete(@PathVariable ("id") Integer id) {
		 
		pizzaRepo.deleteById(id);
		
		 return "redirect:/pizzeria/menu";
	 }
	
	
}
