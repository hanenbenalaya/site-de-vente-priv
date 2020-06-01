 package com.hanen.site.de.vente.priv.model;

import java.util.Date;

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
public class Commande {
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)  

	private long id;
	
	 private Date  date_commande;
	 private Double totale_comande;
	 private String description;
}
