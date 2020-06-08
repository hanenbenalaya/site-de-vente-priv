package com.hanen.site.de.vente.priv.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="CategorieProduit")
@Setter
@Getter
@ToString
@Proxy(lazy = false) 
public class CategorieProd  {
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)  
    private long id;

	private String nom_categorie;
	
 //@OneToMany(targetEntity= Produit.class,cascade=CascadeType.ALL,mappedBy="categorie")
	 //  private Set<Produit> produit;
}
