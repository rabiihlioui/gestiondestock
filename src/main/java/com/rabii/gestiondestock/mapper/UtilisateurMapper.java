package com.rabii.gestiondestock.mapper;

import com.rabii.gestiondestock.dto.UtilisateurDto;
import com.rabii.gestiondestock.model.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UtilisateurMapper {
    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    UtilisateurDto modelToDto(Utilisateur utilisateur);
    Utilisateur dtoToModel(UtilisateurDto utilisateurDto);
    List<UtilisateurDto> modelsToDtos(List<Utilisateur> utilisateurs);
    List<Utilisateur> dtosToModels(List<UtilisateurDto> utilisateurDtos);
}
