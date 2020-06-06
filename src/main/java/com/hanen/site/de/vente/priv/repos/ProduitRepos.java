package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.Produit;

@CrossOrigin("http://localhost:4200")
public interface ProduitRepos extends JpaRepository<Produit, Long> {

 
}
