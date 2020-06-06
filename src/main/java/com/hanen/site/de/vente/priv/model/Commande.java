 package com.hanen.site.de.vente.priv.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@Getter
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)  

	private long cmd_id;
	
	 private String  date_commande;
	 private Double totale_comande;
	 private String description;
	 
	 
	   
	    
	    
}
