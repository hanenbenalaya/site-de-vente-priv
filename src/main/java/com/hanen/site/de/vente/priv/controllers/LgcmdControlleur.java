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
import com.hanen.site.de.vente.priv.model.Facture;
import com.hanen.site.de.vente.priv.model.Produit;
import com.hanen.site.de.vente.priv.model.Client;

import com.hanen.site.de.vente.priv.model.LigneCommande;
import com.hanen.site.de.vente.priv.model.PanierItems;

import com.hanen.site.de.vente.priv.services.LigneCmdService ;
import com.hanen.site.de.vente.priv.services.ProduitService;
import com.hanen.site.de.vente.priv.services.CommandeService ;
import com.hanen.site.de.vente.priv.services.FactureService ;
import com.hanen.site.de.vente.priv.services.ClientService ;



@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/v1")
public class LgcmdControlleur {
	@Autowired
	private LigneCmdService lignecmdService;
	
		@Autowired
	private CommandeService cmdService;
	
	@Autowired
	private ClientService cltService;
	
	@Autowired
	private FactureService factService;
	@Autowired
	private ProduitService prodService;

	@GetMapping("/lignecommandes")
	public List<LigneCommande> getAllLigneCommandes() {

		List<LigneCommande> lcmds = lignecmdService.getAllLigneCommande();
		return lcmds;
	}
	

	@GetMapping("/lignecommandes/{id}")
	public ResponseEntity<LigneCommande> getLigneCommandeById(@PathVariable(value = "id") Long lignecmdId) {
		LigneCommande lcmd = lignecmdService.getLigneCommandeById(lignecmdId).get();
		return ResponseEntity.ok().body(lcmd);
	}
	
	
	@PostMapping("/lignecommande")
	public LigneCommande createLigneCommande(@Valid @RequestBody  LigneCommande lcmdeg) {
		return lignecmdService.createLigneCommande(lcmdeg);
	}
	

	
	@CrossOrigin("*")
    @PostMapping("/lignecommandefull")
	public  Commande createfullLigneCommande(@Valid @RequestBody PanierItems panier) throws Exception {
		System.out.println("client id : "+panier.getClt_id());

		Client clt=cltService.getClientById(panier.getClt_id()).get();
		System.out.println("client: "+clt);

		Commande cmd=new Commande();
		cmd.setClient(clt);
		Facture fact=new Facture();
		fact.setTotale_facture(panier.getMnt_tot());
		System.out.println("facture: "+fact);

		factService.createFacture(fact);
		
		cmd.setFact(fact);
		System.out.println("cmd"+cmd);
		cmdService.createCommande(cmd);
		System.out.println("cmd"+cmd);

		for(int i=0;i< panier.getProduct_list().length;i++  ) {
			LigneCommande  lcmd= new LigneCommande();
			  
		    lcmd.setCmd(cmd);
			System.out.println("lcmd : "+lcmd);

		Produit p=prodService.getProduitById(panier.getProduct_list()[0].getId()).orElseThrow(() -> new ResourceNotFoundException(" product not found for this id :: " ));
		System.out.println("produit : "+p);

		lcmd.setMontant_tot(panier.getProduct_list()[i].getPrixtotale());
		lcmd.setQuantité(panier.getProduct_list()[i].getQuantite());

		lcmd.setProduit(p);
		System.out.println("lcmd: "+lcmd);

		lignecmdService.createLigneCommande(lcmd);
		}
	
		return  cmd;
	}
	
	@PutMapping("/lignecommandes/{id}")
	public ResponseEntity<LigneCommande> updateLigneCommande(@PathVariable(value = "id") Long lcmdId,
			@Valid @RequestBody LigneCommande lcmdDetails) throws ResourceNotFoundException {
		LigneCommande lcmd =lignecmdService.getLigneCommandeById(lcmdId)
				.orElseThrow(() -> new ResourceNotFoundException(" Commande not found for this id :: " + lcmdId));

		lcmd.setId(lcmdDetails.getId());
      
        lcmd.setQuantité(lcmdDetails.getQuantité());
       



		final LigneCommande updatedLigneCommande = lignecmdService.updateLigneCommande(lcmdDetails);
		return ResponseEntity.ok(updatedLigneCommande);
	}
	
	

	@DeleteMapping("/lignecommandes/{id}")
	public Map<String, Boolean> deleteLigneCommande(@PathVariable(value = "id") Long lcmdId)
			throws ResourceNotFoundException {
		LigneCommande lcmd = lignecmdService.getLigneCommandeById(lcmdId)
				.orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: " + lcmdId));

		lignecmdService.deleteLigneCommande(lcmd);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	

}
