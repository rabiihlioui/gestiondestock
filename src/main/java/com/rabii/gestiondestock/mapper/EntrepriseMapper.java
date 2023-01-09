package com.rabii.gestiondestock.mapper;

import com.rabii.gestiondestock.dto.EntrepriseDto;
import com.rabii.gestiondestock.model.Entreprise;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EntrepriseMapper {
    EntrepriseMapper INSTANCE = Mappers.getMapper(EntrepriseMapper.class);

    EntrepriseDto modelToDto(Entreprise entreprise);
    Entreprise dtoToModel(EntrepriseDto entrepriseDto);
    List<EntrepriseDto> modelsToDtos(List<Entreprise> entreprises);
    List<Entreprise> dtosToModels(List<EntrepriseDto> entrepriseDtos);
}
