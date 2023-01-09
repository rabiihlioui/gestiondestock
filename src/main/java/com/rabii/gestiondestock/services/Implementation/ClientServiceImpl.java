package com.rabii.gestiondestock.services.Implementation;

import com.rabii.gestiondestock.dto.ClientDto;
import com.rabii.gestiondestock.dto.ClientDto;
import com.rabii.gestiondestock.exception.EntityNotFoundException;
import com.rabii.gestiondestock.exception.ErrorCodes;
import com.rabii.gestiondestock.exception.InvalidEntityException;
import com.rabii.gestiondestock.mapper.ClientMapper;
import com.rabii.gestiondestock.model.Client;
import com.rabii.gestiondestock.repository.ClientRepository;
import com.rabii.gestiondestock.repository.ClientRepository;
import com.rabii.gestiondestock.services.ClientService;
import com.rabii.gestiondestock.validator.ClientValidator;
import com.rabii.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if(!errors.isEmpty()) {
            log.error("Client is not valid {}", clientDto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return clientMapper.modelToDto(
                clientRepository.save(
                        clientMapper.dtoToModel(clientDto)
                )
        );
    }

    @Override
    public ClientDto findById(Integer idClient) {
        if (idClient == null) {
            log.error("Client ID is null");
            return null;
        }
        Optional<Client> Client = clientRepository.findById(idClient);
        return Optional.of(clientMapper.modelToDto(Client.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun client avec l'ID = " + idClient + " n'est pas trouvé dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                //.map(ArticleDto.class::cast)
                .map(Client -> clientMapper.modelToDto(Client))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idClient) {
        if (idClient == null) {
            log.error("Client ID is null");
            return;
        }
        clientRepository.deleteById(idClient);
    }
}
