package com.hanen.site.de.vente.priv.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Produits")
@Setter
@Getter
@ToString
public class Produit {
	@Id 
	  @GeneratedValue (strategy=GenerationType.IDENTITY)  
	  private Long idProduit;
	
	  private String nomProduit; 
	  private Double prixProduit;
	  private String  urlImage_produit;

	  private String  description_produit;
	  private Double quantite_stock;
	  
	@ManyToOne
	@JoinColumn(name="categorie", nullable=false)
	private CategorieProd categorie;
	  



}
