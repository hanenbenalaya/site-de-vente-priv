package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanen.site.de.vente.priv.model.CategorieProd;
import com.hanen.site.de.vente.priv.repos.categorieProduitRepos;


@Service
public class CategorieServiceImpl implements CategorieService{
	@Autowired
	private categorieProduitRepos categorieRepository;

	@Override
	public List<CategorieProd> getAllCategories() {
		return this.categorieRepository.findAll();
	}

	@Override
	public Optional<CategorieProd> getCategorieById(Long catgorieId) {
		return this.categorieRepository.findById(catgorieId);
	}

	@Override
	public CategorieProd createCategorie(CategorieProd categorie) {
		return this.categorieRepository.save(categorie);
	}

	@Override
	public CategorieProd updateCategorie(CategorieProd categorieDetails) {
		return this.categorieRepository.save(categorieDetails);
	}

	@Override
	public void deleteCategorie(CategorieProd categorie) {
		categorieRepository.delete(categorie);
		
	}

}
