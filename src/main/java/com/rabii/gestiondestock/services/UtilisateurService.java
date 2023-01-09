package com.rabii.gestiondestock.services;

import com.rabii.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto utilisateurDto);
    UtilisateurDto findById(Integer idUtilisateur);
    List<UtilisateurDto> findAll();
    void delete(Integer idUtilisateur);
}
