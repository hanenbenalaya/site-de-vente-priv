package com.hanen.site.de.vente.priv.repos;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.Client;
import com.hanen.site.de.vente.priv.model.Produit;

@CrossOrigin("*")
public interface ClientRepos extends JpaRepository<Client, Long> {

	@CrossOrigin("*")
	Optional<Client> findByemail(@Param("email") String email);


}
