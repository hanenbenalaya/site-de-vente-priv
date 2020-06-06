package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import com.hanen.site.de.vente.priv.model.Facture;

public interface FactureService {
	
	
	List<Facture> getAllFactures();

	 Optional<Facture> getFactureById(Long factureId);

	 Facture createFacture(Facture facture);	

	 Facture updateFacture(Facture factureDetails);

	void deleteFacture(Facture facture);

}
