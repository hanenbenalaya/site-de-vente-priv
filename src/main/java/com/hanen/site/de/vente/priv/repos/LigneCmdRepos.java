package com.hanen.site.de.vente.priv.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.LigneCommande;
@CrossOrigin("http://localhost:4200")
public interface LigneCmdRepos extends JpaRepository<LigneCommande, Long>{

}
