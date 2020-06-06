/**package com.hanen.site.de.vente.priv.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.hanen.site.de.vente.priv.model.CategorieProd;
import com.hanen.site.de.vente.priv.model.Client;
import com.hanen.site.de.vente.priv.model.Commande;
import com.hanen.site.de.vente.priv.model.Facture;
import com.hanen.site.de.vente.priv.model.Produit;


@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	
	
	

   public void configureRepositoryRestCongiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(CategorieProd.class);
		config.exposeIdsFor(Client.class);
		config.exposeIdsFor(Commande.class);
		config.exposeIdsFor(Facture.class);


		
   }
}**/
