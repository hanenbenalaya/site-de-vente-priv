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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="Commande")
@Setter
@Getter
@ToString
public class Commande  {
	
	@Id
    @GeneratedValue (strategy=GenerationType.AUTO)  

	private long cmd_id;
	
	 private String  date_commande;
	 private Double totale_comande;
	 private String description;
	 
	 
	    @ManyToOne
		@JoinColumn(name="clt_id",nullable=false)
		private Client client;
	    
	    
	    @OneToOne
		private Facture facture;
	    
	    @ManyToMany
		@JoinTable(name="produitacmd",
		joinColumns=@JoinColumn(name="cmd_id"),
		inverseJoinColumns=@JoinColumn(name="idProduit"))
        private Set<Produit> listeproduit;
		
	    
	    
}
