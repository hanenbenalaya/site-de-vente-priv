package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import com.hanen.site.de.vente.priv.model.Commande;

public interface CommandeService {
	
	List<Commande> getAllCommandes();

	 Optional<Commande> getCommandeById(Long commandeId);

	 Commande createCommande(Commande commande);	

	 Commande updateCommande(Commande commandeDetails);

	void deleteCommande(Commande commande);

}
