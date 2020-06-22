package com.hanen.site.de.vente.priv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hanen.site.de.vente.priv.model.Client;
@CrossOrigin("http://localhost:4200")

public interface ClientService {
	
	List<Client> getAllClients();

	 Optional<Client> getClientById(Long clientId);

	 Client createClient(Client client);	

	 Client updateClient(Client clientDetails);

	void deleteClient(Client client);
	 Optional<Client> getClientByemail(String email );

}
