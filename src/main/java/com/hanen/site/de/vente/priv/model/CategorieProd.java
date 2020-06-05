package com.hanen.site.de.vente.priv.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="CategorieProduit")
@Setter
@Getter
@ToString
public class CategorieProd  {
	@Id
    @GeneratedValue (strategy=GenerationType.AUTO)  
    private long id;

	private String nom_categorie;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="categorie")
	private Set<Produit> produit;

}
