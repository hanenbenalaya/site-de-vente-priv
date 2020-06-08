package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.CategorieProd;


@CrossOrigin("http://localhost:4200")
public interface categorieProduitRepos  extends JpaRepository <CategorieProd, Long> {

}
