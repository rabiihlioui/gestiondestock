package com.rabii.gestiondestock.services;

import com.rabii.gestiondestock.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save(FournisseurDto fournisseurDto);
    FournisseurDto findById(Integer idFournisseur);
    List<FournisseurDto> findAll();
    void delete(Integer idFournisseur);
}
