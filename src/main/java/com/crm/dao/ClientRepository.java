package com.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //List<Client> findAllByLastName(String lastName);
}
    