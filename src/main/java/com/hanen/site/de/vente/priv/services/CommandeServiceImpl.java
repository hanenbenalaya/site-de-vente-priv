package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanen.site.de.vente.priv.model.Commande;
import com.hanen.site.de.vente.priv.repos.CommandeRepos;


@Service
public class CommandeServiceImpl implements CommandeService {

	
	@Autowired
	private CommandeRepos cmdRepository;
	
	@Override
	public List<Commande> getAllCommandes() {
		return this.cmdRepository.findAll();
	}

	@Override
	public Optional<Commande> getCommandeById(Long commandeId) {
		return this.cmdRepository.findById(commandeId);
	}

	@Override
	public Commande createCommande(Commande commande) {
		return  this.cmdRepository.save(commande);
	}

	@Override
	public Commande updateCommande(Commande commandeDetails) {
		return this.cmdRepository.save(commandeDetails);
	}

	@Override
	public void deleteCommande(Commande commande) {
		cmdRepository.delete(commande);		
	}

}
