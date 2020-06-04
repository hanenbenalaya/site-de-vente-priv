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
@Table(name="Client")
@Setter
@Getter
@ToString
public class Client {
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)  

	private long clt_id;

	private String firstname;
	private String lastname;
	private String email;
	private long phone ;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="client")
	private Set<Commande> cmd;

}
