package com.hanen.site.de.vente.priv.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.hanen.site.de.vente.priv.model.AuthObj;
import com.hanen.site.de.vente.priv.model.Client;
import com.hanen.site.de.vente.priv.repos.ClientRepos;
import com.hanen.site.de.vente.priv.services.ClientService;
@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/api/v1")
public class ClientControlleur {
	@Autowired
	private  ClientRepos clientRepos;
	@Autowired
	private ClientService clientService;
	@CrossOrigin("http://localhost:4200")

	@GetMapping("/clients")
	public Page<Client> getAllClients(@RequestParam(name="page")int page,@RequestParam(name="size", defaultValue="5")int size) {

		Page<Client> clients = clientRepos.findAll(PageRequest.of(page, size));
		return clients;
	}
	
	
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long cltId) {
		Client client = clientService.getClientById(cltId).get();
		return ResponseEntity.ok().body(client);
	}
	
	@PostMapping("/clients")
	public Client createClient(@Valid @RequestBody Client clteg) {
		return clientService.createClient(clteg);
	}
	
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long cltId,
			@Valid @RequestBody Client cltDetails) throws ResourceNotFoundException {
		Client clt = clientService.getClientById(cltId)
				.orElseThrow(() -> new ResourceNotFoundException(" Client not found for this id :: " + cltId));

		clt.setClt_id(cltDetails.getClt_id());
        clt.setEmail(cltDetails.getEmail());
        clt.setEmail(cltDetails.getEmail());
        clt.setMdp(cltDetails.getMdp());
        clt.setNom(cltDetails.getNom());
        clt.setPrenom(cltDetails.getPrenom());
        clt.setTelephone(cltDetails.getTelephone());




		final Client updatedClient = clientService.updateClient(cltDetails);
		return ResponseEntity.ok(updatedClient);
	}
	
	
	
	@DeleteMapping("/clients/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long cltId)
			throws ResourceNotFoundException {
		Client clt = clientService.getClientById(cltId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + cltId));
System.out.println("client a supprimé"+clt);
		clientService.deleteClient(clt);
		System.out.println("client  supprimé");

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/clientauth")
	public String getClientId(@Valid @RequestBody AuthObj auth) {
	
		Client client = clientService.getClientByemail(auth.getEmail()).get();
System.out.println("client:"+client);
		String id =String.valueOf(client.getClt_id());
		System.out.println("client id :"+id);
		return (id);
		
		
	}
	
	
	
	

}
