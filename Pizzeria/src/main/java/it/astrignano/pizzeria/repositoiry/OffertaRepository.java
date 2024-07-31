package it.astrignano.pizzeria.repositoiry;

import org.springframework.data.jpa.repository.JpaRepository;

import it.astrignano.pizzeria.model.OffertaModel;

public interface OffertaRepository extends JpaRepository<OffertaModel, Integer> 
{

}
