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
import it.astrignano.pizzeria.model.OffertaModel;
import it.astrignano.pizzeria.repositoiry.OffertaRepository;
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

	
//--------DELETE---------
		@PostMapping("/delete/{id}")
		 public String deleteOfferta(@PathVariable ("id") Integer id, OffertaModel offerta) {
			
			Integer pizzaId = offertaRepo.findById(id).get().getPizza().getId();
			offertaRepo.deleteById(id);
			
			return "redirect:/pizzeria/dettaglio/" + pizzaId;
		 }
		
		
//----------EDIT---------
		@GetMapping("/edit/{id}")
		public String editOfferta(@PathVariable("id") Integer id, Model model) {
			
			OffertaModel offerta = offertaRepo.findById(id).get();
			model.addAttribute("offerta", offerta);
			model.addAttribute("editMode", true);
			
			return"/offerte/create";
		}
		
		@PostMapping("/edit/{id}")
		public String storeEditOfferta(
				@Valid @ModelAttribute("offerta") OffertaModel offerta, Model model,
				BindingResult bindingResult) {

			if (bindingResult.hasErrors()){
				return "/offerte/create";
			}
			
			offertaRepo.save(offerta);
			
			return "redirect:/pizzeria/dettaglio/" + offerta.getPizza().getId();
		}
	
}
