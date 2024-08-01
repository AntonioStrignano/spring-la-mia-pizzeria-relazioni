package it.astrignano.pizzeria.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Bindable.BindRestriction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.astrignano.pizzeria.model.OffertaModel;
import it.astrignano.pizzeria.model.PizzaModel;
import it.astrignano.pizzeria.repositoiry.OffertaRepository;
import it.astrignano.pizzeria.repositoiry.PizzaRepository;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/offerte")
public class OffertaController {

	@Autowired
	private OffertaRepository offertaRepo;
	
	
//	-----CREATE-----
	@PostMapping("/create")
	public String storeOfferta(@Valid @ModelAttribute("offerta") OffertaModel offerta,
			BindingResult bindingResult,  Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/offerta/create-offerta";
		}
		offertaRepo.save(offerta);
		
		return"redirect:/pizzeria/dettaglio/" + offerta.getPizza().getId();
	}

	
	//------DELETE-------
		@PostMapping("/delete/{id}")
		 public String delete(@PathVariable ("id") Integer id) {
			 
			offertaRepo.deleteById(id);
			
			 return "redirect:/pizzeria/menu";
		 }
		
	
}
