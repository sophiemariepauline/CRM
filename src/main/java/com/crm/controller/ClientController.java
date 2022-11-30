package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.model.Client;
import com.crm.service.ClientDirectory;

@RestController
@RequestMapping("api")
public class ClientController {
	
	@Autowired
	private ClientDirectory clientDirectory;
	
	@GetMapping("clients")
	public List<Client> getClients(){
		
		return clientDirectory.getClients();
	}
	
	@PostMapping("clients")
	public Client postClient(@RequestBody Client newClient) {
		clientDirectory.addClient(newClient);		
		return newClient;
	}

	@DeleteMapping("clients/{id}")
	public void deleteClient(@PathVariable("id") Long id){
		clientDirectory.deleteClient(id);
	}

	@PutMapping("clients/{id}")
	public ResponseEntity updateClient(@RequestBody Client client, @PathVariable("id") Long id){

		if(id != client.getId()){
			return ResponseEntity.badRequest().build();
		}
		else {

			clientDirectory.updateClient(client);
			return ResponseEntity.ok().build();
		}
	}
}