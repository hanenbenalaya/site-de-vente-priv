package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.Client;

@CrossOrigin("http://localhost:4200")
public interface ClientRepos extends CrudRepository<Client, Long> {

}
