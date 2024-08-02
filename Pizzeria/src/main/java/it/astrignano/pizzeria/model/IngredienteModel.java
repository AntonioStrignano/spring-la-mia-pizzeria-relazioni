package it.astrignano.pizzeria.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ingrediente")
public class IngredienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotBlank(message = "Il nome dell'ingrediente e' obbligatorio. ")
	@Column(name="nome", nullable =false)
	private String nome;
	
	@ManyToMany(mappedBy="ingredienti")
	private List<PizzaModel> pizze;

//-------GETTER E SETTER-------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PizzaModel> getPizze() {
		return pizze;
	}

	public void setPizze(List<PizzaModel> pizze) {
		this.pizze = pizze;
	}

	
	
	
}
