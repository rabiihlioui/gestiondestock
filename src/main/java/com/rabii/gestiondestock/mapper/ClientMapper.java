package com.rabii.gestiondestock.mapper;

import com.rabii.gestiondestock.dto.ClientDto;
import com.rabii.gestiondestock.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto modelToDto(Client client);
    Client dtoToModel(ClientDto clientDto);
    List<ClientDto> modelsToDtos(List<Client> clients);
    List<Client> dtosToModels(List<ClientDto> clientDtos);
}
