package com.hanen.site.de.vente.priv.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanen.site.de.vente.priv.exception.ResourceNotFoundException;
import com.hanen.site.de.vente.priv.model.CategorieProd;
import com.hanen.site.de.vente.priv.model.Produit;
import com.hanen.site.de.vente.priv.model.ProduitOperation;
import com.hanen.site.de.vente.priv.repos.ProduitRepos;
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
	
	
	@Autowired
	private ProduitRepos produitRepos;



	@GetMapping("/produits")
	public Page<Produit> getAllProduits(@RequestParam(name="page")int page,@RequestParam(name="size", defaultValue="5")int size) {

		Page<Produit> produits = produitRepos.findAll(PageRequest.of(page, size));
		return produits;
	}
	
	@GetMapping("/produits/{id}/{page}/{size}")
	  public ResponseEntity<Map<String, Object>> getArtParPage(@PathVariable(value ="id")long  id,
			  @PathVariable("page") int page, 
				@PathVariable("size") int size){
	    try {      
	      List<Produit> produits = new ArrayList<Produit>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Produit> pagedResult = produitRepos.findByCategorieId(id, paging);
	      produits = pagedResult.getContent();
	      
	      if (produits.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      
	      Map<String, Object> response = new HashMap<>();
	      response.put("articles", produits);
	      response.put("currentPage", pagedResult.getNumber());
	      response.put("totalItems", pagedResult.getTotalElements());
	      response.put("totalPages", pagedResult.getTotalPages());
	      response.put("size", pagedResult.getSize());
	      
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
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
	@CrossOrigin("*")
	@DeleteMapping("/proddel/{id}")
	public Map<String, Boolean> deleteProduit(@PathVariable(value = "id") Long produitId)
			throws ResourceNotFoundException {
		Produit produit = produitService.getProduitById(produitId)
				
				.orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + produitId));
System.out.println("produit a supprimé"+produit);
		produitService.deleteProduit(produit);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	
	

}
