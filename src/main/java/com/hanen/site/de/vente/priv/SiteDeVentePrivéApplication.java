package com.hanen.site.de.vente.priv;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.hanen.site.de.vente.priv.model.Produit;

@SpringBootApplication
public class SiteDeVentePrivéApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
   
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
    
	public static void main(String[] args) {
		SpringApplication.run(SiteDeVentePrivéApplication.class, args);
		
	
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		restConfiguration.exposeIdsFor(Produit.class);
	}
	

}
 