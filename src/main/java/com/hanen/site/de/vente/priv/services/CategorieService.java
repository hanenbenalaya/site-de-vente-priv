package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import com.hanen.site.de.vente.priv.model.CategorieProd;

public interface CategorieService {
	
	List<CategorieProd> getAllCategories();

	 Optional<CategorieProd> getCategorieById(Long catgorieId);

	CategorieProd createCategorie(CategorieProd categorie);	

	CategorieProd updateCategorie(CategorieProd categorieDetails);

	void deleteCategorie(CategorieProd categorie);

}
