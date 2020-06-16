package com.hanen.site.de.vente.priv.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProduitOperation {
	 private Long idProduit;
		
	  private String nomProduit; 
	  private Double prixProduit;
	  private String  urlImage_produit;

	  private String  description_produit;
	  private Double quantite_stock;
	private Long categorie;
	

}
