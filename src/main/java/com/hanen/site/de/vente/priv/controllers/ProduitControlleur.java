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
import com.hanen.site.de.vente.priv.model.Produit;
import com.hanen.site.de.vente.priv.model.ProduitOperation;
import com.hanen.site.de.vente.priv.services.CategorieService;
import com.hanen.site.de.vente.priv.services.ProduitService;
@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1")
public class ProduitControlleur {
	
	@Autowired
	private ProduitService produitService;
	@Autowired
	private CategorieService  categorieService;
	
	
	



	@GetMapping("/produits")
	public List<Produit> getAllProduits() {

		List<Produit> produits = produitService.getAllProduits();
		return produits;
	}
	@GetMapping("/produits/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable(value = "id") Long produitId) {
		Produit produit = produitService.getProduitById(produitId).get();
		return ResponseEntity.ok().body(produit);
	}
	
	
	
	@PostMapping("/produits")
	public Produit createProduit(@Valid @RequestBody Produit produit) {
		return produitService.createProduit(produit);
	}
	
	
	
	@PutMapping("/produits/{id}")
	public ResponseEntity<Produit> updateProduit(@PathVariable(value = "id") Long produitId,
			@Valid @RequestBody Produit produitDetails) throws ResourceNotFoundException {
		Produit produit = produitService.getProduitById(produitId)
				.orElseThrow(() -> new ResourceNotFoundException(" Product not found for this id :: " + produitId));

		produit.setNomProduit(produitDetails.getNomProduit());
        produit.setPrixProduit(produitDetails.getPrixProduit());
		produit.setUrlImage_produit(produitDetails.getUrlImage_produit());
		produit.setDescription_produit(produitDetails.getDescription_produit());
		produit.setQuantite_stock(produitDetails.getQuantite_stock());

		final Produit updatedProduit = produitService.updateProduit(produitDetails);
		return ResponseEntity.ok(updatedProduit);
	}
	@CrossOrigin("*")
	@PostMapping("/produitscateg")
	public Produit addProduit(
			@Valid @RequestBody ProduitOperation produitcateg) throws ResourceNotFoundException {
		Long id= produitcateg.getCategorie();
		System.out.println("produit recu nom :"+produitcateg.getNomProduit());
		System.out.println("produit recu categ :"+produitcateg.getCategorie());
		System.out.println("produit recu  descrip:"+produitcateg.getDescription_produit());
		System.out.println("produit recu image :"+produitcateg.getUrlImage_produit());
		System.out.println("produit recu prix :"+produitcateg.getPrixProduit());
		System.out.println("produit recu qstck:"+produitcateg.getQuantite_stock());

		CategorieProd categ = categorieService.getCategorieById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" categorie not found for this id :: " + id));
System.out.println("categorie:"+id);
Produit produit=new Produit();
		produit.setNomProduit(produitcateg.getNomProduit());
        produit.setPrixProduit(produitcateg.getPrixProduit());
		produit.setUrlImage_produit(produitcateg.getUrlImage_produit());
		produit.setDescription_produit(produitcateg.getDescription_produit());
		produit.setQuantite_stock(produitcateg.getQuantite_stock());
		produit.setCategorie(categ);


		return produitService.createProduit(produit);
	}
	@DeleteMapping("/produits/{id}")
	public Map<String, Boolean> deleteProduit(@PathVariable(value = "id") Long produitId)
			throws ResourceNotFoundException {
		Produit produit = produitService.getProduitById(produitId)
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + produitId));

		produitService.deleteProduit(produit);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	
	

}
