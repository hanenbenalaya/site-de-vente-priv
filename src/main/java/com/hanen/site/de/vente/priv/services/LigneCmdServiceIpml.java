package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanen.site.de.vente.priv.model.LigneCommande;
import com.hanen.site.de.vente.priv.repos.LigneCmdRepos;
@Service
public class LigneCmdServiceIpml implements LigneCmdService {
	@Autowired
	private LigneCmdRepos lignecmdRepository;
	

	@Override
	public List<LigneCommande> getAllLigneCommande() {
		return this.lignecmdRepository.findAll();
	}

	@Override
	public Optional<LigneCommande> getLigneCommandeById(Long ligneCommandeId) {
		return  this.lignecmdRepository.findById(ligneCommandeId);
	}

	@Override
	public LigneCommande createLigneCommande(LigneCommande ligneCommande) {
		return this.lignecmdRepository.save(ligneCommande);
	}

	@Override
	public LigneCommande updateLigneCommande(LigneCommande LigneCommandeDetails) {
		
		return this.lignecmdRepository.save( LigneCommandeDetails);	}

	@Override
	public void deleteLigneCommande(LigneCommande ligneCommande) {
		lignecmdRepository.delete(ligneCommande);			
	}

}
