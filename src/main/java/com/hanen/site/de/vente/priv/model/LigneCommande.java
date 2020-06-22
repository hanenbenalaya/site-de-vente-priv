package com.hanen.site.de.vente.priv.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="Ligne_Commande")
@Setter
@Getter
@ToString
public class LigneCommande {
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)  
    private long id;
	private long quantité;
	private long montant_tot;
		 @ManyToOne
			@JoinColumn(name="cmd_id",nullable=false)
			private Commande cmd; 
	 @ManyToOne
		@JoinColumn(name="idProduit",nullable=false)
		private Produit produit; 

		
}
