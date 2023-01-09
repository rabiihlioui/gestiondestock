package com.rabii.gestiondestock.services;

import com.rabii.gestiondestock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto save(EntrepriseDto entrepriseDto);
    EntrepriseDto findById(Integer idEntreprise);
    List<EntrepriseDto> findAll();
    void delete(Integer idEntreprise);
}
