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
import com.hanen.site.de.vente.priv.model.Commande;
import com.hanen.site.de.vente.priv.services.CommandeService;
@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/v1")
public class CommandeControlleur {
	
	@Autowired
	private CommandeService cmdService;
	
	
	
	@GetMapping("/commandes")
	public List<Commande> getAllCommandes() {

		List<Commande> cmds = cmdService.getAllCommandes();
		return cmds;
	}
	

	@GetMapping("/commandes/{id}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable(value = "id") Long cmdId) {
		Commande cmd = cmdService.getCommandeById(cmdId).get();
		return ResponseEntity.ok().body(cmd);
	}
	
	
	@PostMapping("/commande")
	public Commande createCommande(@Valid @RequestBody Commande cmdeg) {
		return cmdService.createCommande(cmdeg);
	}
	
	
	
	@PutMapping("/commandes/{id}")
	public ResponseEntity<Commande> updateCommande(@PathVariable(value = "id") Long cmdId,
			@Valid @RequestBody Commande cmdDetails) throws ResourceNotFoundException {
		Commande cmd = cmdService.getCommandeById(cmdId)
				.orElseThrow(() -> new ResourceNotFoundException(" Commande not found for this id :: " + cmdId));

		cmd.setCmd_id(cmdDetails.getCmd_id());
        cmd.setDate_commande(cmdDetails.getDate_commande());
        cmd.setDescription(cmdDetails.getDescription());
        cmd.setTotale_comande(cmdDetails.getTotale_comande());
       



		final Commande updatedCommande = cmdService.updateCommande(cmdDetails);
		return ResponseEntity.ok(updatedCommande);
	}
	
	

	@DeleteMapping("/commandes/{id}")
	public Map<String, Boolean> deleteCommande(@PathVariable(value = "id") Long cmdId)
			throws ResourceNotFoundException {
		Commande cmd = cmdService.getCommandeById(cmdId)
				.orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: " + cmdId));

		cmdService.deleteCommande(cmd);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
}
