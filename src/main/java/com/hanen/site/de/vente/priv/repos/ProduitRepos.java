package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanen.site.de.vente.priv.model.Produit;

@CrossOrigin("*")
public interface ProduitRepos extends JpaRepository<Produit, Long> {
	
	@RestResource(path = "categorieid")
	 Page<Produit>	findByCategorieId(@Param("id") Long id,Pageable pageable );
 
	
	
	@RestResource(path = "searchbykeyword")
	 Page<Produit>	findBynomProduitContaining(@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size", defaultValue="5")int size,@Param("nomProduit") String keyword );

}
