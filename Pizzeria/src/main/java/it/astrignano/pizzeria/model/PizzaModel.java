package it.astrignano.pizzeria.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="pizza")
public class PizzaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NotBlank(message = "Il nome della pizza e' obbligatorio. ")
	@Column(name="nome", nullable =false)
	private String nome;
	
	@NotBlank(message = "La descr della pizza e' obbligatoria. ")
	@Column(name="descrizione", nullable=false)
	private String descrizione;
	
	@NotBlank(message = "L'url della pizza e' obbligatorio. ")
	@Column(name = "foto_url", nullable = true)
	private String fotoUrl;
	
	
	@NotNull(message="Il prezzo e' obbligatorio. ")
	@Column(name="price", nullable = true)
	private double price;

	@OneToMany(mappedBy = "pizza")
	private List<OffertaModel> offerte;
	
	
	public List<OffertaModel> getOfferte() {
		return offerte;
	}

	public void setOfferte(List<OffertaModel> offerte) {
		this.offerte = offerte;
	}

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PizzaModel [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", fotoUrl=" + fotoUrl
				+ ", price=" + price + "]";
	}
	
	
}
