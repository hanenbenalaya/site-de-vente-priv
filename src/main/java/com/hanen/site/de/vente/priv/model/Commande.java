 package com.hanen.site.de.vente.priv.model;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @GeneratedValue (strategy=GenerationType.IDENTITY)  
    private long cmd_id;
	
	 @OneToOne
		@JoinColumn(name="id",nullable=false)
        private Facture	fact;
	 
	 @ManyToOne
	@JoinColumn(name="clt_id",nullable=false)
	private Client client; 
	    
	
		
		 
	 }
	    
	    

