package com.hanen.site.de.vente.priv.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanen.site.de.vente.priv.exception.ResourceNotFoundException;
import com.hanen.site.de.vente.priv.model.CategorieProd;
import com.hanen.site.de.vente.priv.services.CategorieService;
@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/v1")
public class CategorieContrelleur {
	
	@Autowired
	private CategorieService categorieService;
	
	
	
	@GetMapping("/categories")
	public List<CategorieProd> getAllCategories() {

		List<CategorieProd> categories = categorieService.getAllCategories();
		return categories;
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategorieProd> getCategorieById(@PathVariable(value = "id") Long catId) {
		CategorieProd categorie = categorieService.getCategorieById(catId).get();
		return ResponseEntity.ok().body(categorie);
	}
	
	@PostMapping("/categories")
	public CategorieProd createCategorie(@Valid @RequestBody CategorieProd categ) {
		return categorieService.createCategorie(categ);
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<CategorieProd> updateCategorie(@PathVariable(value = "id") Long catId,
			@Valid @RequestBody CategorieProd catDetails) throws ResourceNotFoundException {
		CategorieProd cat = categorieService.getCategorieById(catId)
				.orElseThrow(() -> new ResourceNotFoundException(" Categorie not found for this id :: " + catId));

		cat.setNom_categorie(catDetails.getNom_categorie());
        cat.setId(catDetails.getId());


		final CategorieProd updatedCategorie = categorieService.updateCategorie(catDetails);
		return ResponseEntity.ok(updatedCategorie);
	}
	
	
	
	@DeleteMapping("/categories/{id}")
	public Map<String, Boolean> deleteCategorie(@PathVariable(value = "id") Long catId)
			throws ResourceNotFoundException {
		CategorieProd cat = categorieService.getCategorieById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this id :: " + catId));

		categorieService.deleteCategorie(cat);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
