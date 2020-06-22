package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import com.hanen.site.de.vente.priv.model.LigneCommande;

public interface LigneCmdService {
	List<LigneCommande> getAllLigneCommande();

	 Optional<LigneCommande> getLigneCommandeById(Long ligneCommandeId);

	 LigneCommande createLigneCommande(LigneCommande ligneCommande);	

	 LigneCommande updateLigneCommande(LigneCommande LigneCommandeDetails);

	void deleteLigneCommande(LigneCommande ligneCommande);
}
