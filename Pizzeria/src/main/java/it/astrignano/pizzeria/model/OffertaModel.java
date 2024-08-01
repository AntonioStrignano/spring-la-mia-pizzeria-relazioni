package it.astrignano.pizzeria.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="offerta")
public class OffertaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotBlank(message = "Il titolo dell'offerta e' obbligatorio. ")
	@Column(name="titolo", nullable =false)
	private String titolo;
	
	@NotNull(message = "La data di inizio e' obbligatoria. ")
	@Column(name="data_inizio", nullable=false)
	private LocalDate dataInizio;

	@NotNull(message = "La data di fine e' obbligatoria. ")
	@Column(name="data_fine", nullable=false)
	private LocalDate dataFine;
	
	
	@ManyToOne
	@JoinColumn(name="pizza_id", nullable=false)
	private PizzaModel pizza;

	public PizzaModel getPizza() {
		return pizza;
	}

	public void setPizza(PizzaModel pizza) {
		this.pizza = pizza;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OffertaModel [id=" + id + ", titolo=" + titolo + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine
				+ "]";
	}

	
}
