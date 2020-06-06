package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import com.hanen.site.de.vente.priv.model.Client;

public interface ClientService {
	
	List<Client> getAllClients();

	 Optional<Client> getClientById(Long clientId);

	 Client createClient(Client client);	

	 Client updateClient(Client clientDetails);

	void deleteClient(Client client);

}
