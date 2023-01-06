package com.rabii.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface GenericRepository<E, IDType> extends JpaRepository<E, IDType> {
}
