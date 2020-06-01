package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.repository.CrudRepository;

import com.hanen.site.de.vente.priv.model.Commande;

public interface CommandeRepos extends CrudRepository<Commande, Long>{

}
