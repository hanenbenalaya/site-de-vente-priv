package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanen.site.de.vente.priv.model.Facture;
import com.hanen.site.de.vente.priv.repos.FactureRepos;



@Service
public class FactureServiceImpl implements FactureService {
	
	@Autowired
	private FactureRepos factureRepository;

	@Override
	public List<Facture> getAllFactures() {
		return this.factureRepository.findAll();
	}
	@Override
	public Optional<Facture> getFactureById(Long factureId) {
		return 	this.factureRepository.findById(factureId);

	}

	@Override
	public Facture createFacture(Facture facture) {
		return this.factureRepository.save(facture);
	}

	@Override
	public Facture updateFacture(Facture factureDetails) {
		
		return this.factureRepository.save(factureDetails);
	}

	@Override
	public void deleteFacture(Facture facture) {
		factureRepository.delete(facture);		
	}

}
