package com.rabii.gestiondestock.services.Implementation;

import com.rabii.gestiondestock.dto.EntrepriseDto;
import com.rabii.gestiondestock.dto.EntrepriseDto;
import com.rabii.gestiondestock.exception.EntityNotFoundException;
import com.rabii.gestiondestock.exception.ErrorCodes;
import com.rabii.gestiondestock.exception.InvalidEntityException;
import com.rabii.gestiondestock.mapper.EntrepriseMapper;
import com.rabii.gestiondestock.model.Entreprise;
import com.rabii.gestiondestock.repository.EntrepriseRepository;
import com.rabii.gestiondestock.services.EntrepriseService;
import com.rabii.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    private final EntrepriseRepository entrepriseRepository;

    private final EntrepriseMapper entrepriseMapper;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository, EntrepriseMapper entrepriseMapper) {
        this.entrepriseRepository = entrepriseRepository;
        this.entrepriseMapper = entrepriseMapper;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()) {
            log.error("Entreprise is not valid {}", entrepriseDto);
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }
        return entrepriseMapper.modelToDto(
                entrepriseRepository.save(
                        entrepriseMapper.dtoToModel(entrepriseDto)
                )
        );
    }

    @Override
    public EntrepriseDto findById(Integer idEntreprise) {
        if (idEntreprise == null) {
            log.error("Entreprise ID is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(idEntreprise);
        return Optional.of(entrepriseMapper.modelToDto(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune entreprise avec l'ID = " + idEntreprise + " n'est pas trouvé dans la BDD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND
                )
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                //.map(ArticleDto.class::cast)
                .map(Entreprise -> entrepriseMapper.modelToDto(Entreprise))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idEntreprise) {
        if (idEntreprise == null) {
            log.error("Entreprise ID is null");
            return;
        }
        entrepriseRepository.deleteById(idEntreprise);
    }
}
