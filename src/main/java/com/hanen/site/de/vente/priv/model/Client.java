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
@Table(name="Client")
@Setter
@Getter
@ToString
public class Client {
	
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)  

	private long clt_id;

	private String nom;
	private String prenom;
	private String email;
	private long telephone ;
	private String mdp;
	

}
