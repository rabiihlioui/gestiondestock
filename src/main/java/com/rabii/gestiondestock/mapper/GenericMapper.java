package com.rabii.gestiondestock.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenericMapper<DTO, E> {
    GenericMapper INSTANCE = Mappers.getMapper(GenericMapper.class);

    //@Mapping(source = "E", target = "code")
    DTO modelToDto(E entity);
    List<DTO> modelsToDtos(List<E> entities);
    //@InheritInverseConfiguration
    E dtoToModel(DTO dto);
}
