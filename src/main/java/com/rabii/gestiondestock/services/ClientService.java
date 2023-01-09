package com.rabii.gestiondestock.services;

import com.rabii.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto clientDto);
    ClientDto findById(Integer idClient);
    List<ClientDto> findAll();
    void delete(Integer idClient);
}
