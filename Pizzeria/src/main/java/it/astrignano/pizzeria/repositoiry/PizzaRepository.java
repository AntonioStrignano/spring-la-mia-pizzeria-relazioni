package it.astrignano.pizzeria.repositoiry;

import org.springframework.data.jpa.repository.JpaRepository;

import it.astrignano.pizzeria.model.PizzaModel;

public interface PizzaRepository extends JpaRepository<PizzaModel, Integer> {

	
}
