package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.Produit;

@CrossOrigin("http://localhost:4200")
public interface ProduitRepos extends CrudRepository<Produit, Long> {

 Page<Produit>	findByCategorieId(@Param("id") Long id,Pageable pageable );
}
