package it.astrignano.pizzeria.repositoiry;

import org.springframework.data.jpa.repository.JpaRepository;

import it.astrignano.pizzeria.model.IngredienteModel;

public interface IngredienteRepository extends JpaRepository<IngredienteModel, Integer>{

}
