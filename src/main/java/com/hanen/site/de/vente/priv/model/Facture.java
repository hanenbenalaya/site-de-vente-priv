package com.hanen.site.de.vente.priv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Facture")
@Setter
@Getter
@ToString
public class Facture {

	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)  
    private long id;
	
	 private Double tva;
	 private Double remise;
	 private Double totale_facture;
	
	  @OneToOne
	  @JoinColumn(name = "commande")
	  private Commande cmd;
}
