package com.rabii.gestiondestock.mapper;

import com.rabii.gestiondestock.dto.FournisseurDto;
import com.rabii.gestiondestock.model.Fournisseur;
import com.rabii.gestiondestock.model.Fournisseur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FournisseurMapper {
    FournisseurMapper INSTANCE = Mappers.getMapper(FournisseurMapper.class);

    FournisseurDto modelToDto(Fournisseur fournisseur);
    Fournisseur dtoToModel(FournisseurDto fournisseurDto);
    List<FournisseurDto> modelsToDtos(List<Fournisseur> fournisseurs);
    List<Fournisseur> dtosToModels(List<FournisseurDto> fournisseurDtos);
}
