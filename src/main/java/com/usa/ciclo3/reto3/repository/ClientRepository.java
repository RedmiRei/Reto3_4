package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.crudrepository.ClientCrudRepository;
import com.usa.ciclo3.reto3.model.Category;
import com.usa.ciclo3.reto3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){

        return (List<Client>)clientCrudRepository.findAll();
    }
    public Optional <Client> getClient(int idClient){

        return clientCrudRepository.findById(idClient);
    }
    public Client save (Client client){

        return clientCrudRepository.save(client);
    }
    public void delete(Client client){

        clientCrudRepository.delete (client);
    }
}
