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

	private long id;

	private String firstname;
	private String lastname;
	private String email;
	private long phone ;
	private String password;

   

}
