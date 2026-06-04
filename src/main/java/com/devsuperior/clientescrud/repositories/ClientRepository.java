package com.devsuperior.clientescrud.repositories;

import com.devsuperior.clientescrud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
