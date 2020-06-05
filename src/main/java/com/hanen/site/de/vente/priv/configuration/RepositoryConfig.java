package com.hanen.site.de.vente.priv.configuration;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	
	
	@Autowired
	private EntityManager entityManager;
	

   public void configureRepositoryRestCongiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));
   
   }
}
