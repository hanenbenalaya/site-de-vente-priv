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
import com.hanen.site.de.vente.priv.model.Facture;
import com.hanen.site.de.vente.priv.services.FactureService;
@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/v1")
public class FactureControleur {
	
	@Autowired
	private FactureService factureService;
	
	
	@GetMapping("/factures")
	public List<Facture> getAllFactures() {

		List<Facture> factures = factureService.getAllFactures();
		return factures;
	}
	
	
	
	@GetMapping("/factures/{id}")
	public ResponseEntity<Facture> getFactureById(@PathVariable(value = "id") Long fctId) {
		Facture facture = factureService.getFactureById(fctId).get();
		return ResponseEntity.ok().body(facture);
	}
	
	
	
	@PostMapping("/factures")
	public Facture createFacture(@Valid @RequestBody Facture fcteg) {
		return factureService.createFacture(fcteg);
	}

	
	
	@PutMapping("/factures/{id}")
	public ResponseEntity<Facture> updateFacture(@PathVariable(value = "id") Long fctId,
			@Valid @RequestBody Facture fctDetails) throws ResourceNotFoundException {
		Facture fct = factureService.getFactureById(fctId)
				.orElseThrow(() -> new ResourceNotFoundException(" Facture not found for this id :: " + fctId));

		fct.setId(fctDetails.getId());
        fct.setTva(fctDetails.getTva());
        fct.setRemise(fctDetails.getRemise());
        fct.setTotale_facture(fctDetails.getTotale_facture());
       



		final Facture updatedFacture = factureService.updateFacture(fctDetails);
		return ResponseEntity.ok(updatedFacture);
	}
	
	
	

	@DeleteMapping("/factures/{id}")
	public Map<String, Boolean> deleteFacture(@PathVariable(value = "id") Long fctId)
			throws ResourceNotFoundException {
		Facture fct = factureService.getFactureById(fctId)
				.orElseThrow(() -> new ResourceNotFoundException("Facture not found for this id :: " + fctId));

		factureService.deleteFacture(fct);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
}
