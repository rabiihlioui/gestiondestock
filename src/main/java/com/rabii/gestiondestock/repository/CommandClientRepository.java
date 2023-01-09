package com.rabii.gestiondestock.repository;

import com.rabii.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandClientRepository extends JpaRepository<CommandeClient, Integer> {
}
