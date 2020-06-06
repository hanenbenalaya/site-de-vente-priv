package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanen.site.de.vente.priv.model.Produit;
import com.hanen.site.de.vente.priv.repos.ProduitRepos;


@Service
public class ProduitServiceImpl implements ProduitService{

	@Autowired
	private ProduitRepos produitRepository;
	
	
	@Override
	public List<Produit> getAllProduits() {
		return this.produitRepository.findAll();
	}

	@Override
	public  Optional<Produit> getProduitById(Long produitId) {
		return this.produitRepository.findById(produitId);
	}

	

	@Override
	public Produit createProduit(Produit produit) {
		
		return this.produitRepository.save(produit);
	}



	@Override
	public Produit updateProduit(Produit produitDetails) {
		return this.produitRepository.save(produitDetails);

	}

	@Override
	public void deleteProduit(Produit produit) {
		produitRepository.delete(produit);
		
	}

}
