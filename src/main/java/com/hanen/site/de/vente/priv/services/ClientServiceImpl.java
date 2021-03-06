package com.hanen.site.de.vente.priv.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.Client;
import com.hanen.site.de.vente.priv.repos.ClientRepos;
@CrossOrigin("http://localhost:4200")

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepos clientRepository;
	
	
	@Override
	public List<Client> getAllClients() {
		
		return this.clientRepository.findAll();
	}

	@Override
	public Optional<Client> getClientById(Long clientId) {
		
		return  this.clientRepository.findById(clientId);
	}

	@Override
	public Client createClient(Client client) {
		return this.clientRepository.save(client);
	}

	@Override
	public Client updateClient(Client clientDetails) {
		return this.clientRepository.save(clientDetails);
	}

	@Override
	public void deleteClient(Client client) {
		clientRepository.delete(client);		
	}

	@Override
	public Optional<Client> getClientByemail(String email) {
		return  this.clientRepository.findByemail(email);
		
	}

}
