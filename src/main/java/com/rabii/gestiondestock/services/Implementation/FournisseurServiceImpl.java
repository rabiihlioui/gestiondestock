package com.rabii.gestiondestock.services.Implementation;

import com.rabii.gestiondestock.dto.FournisseurDto;
import com.rabii.gestiondestock.dto.FournisseurDto;
import com.rabii.gestiondestock.exception.EntityNotFoundException;
import com.rabii.gestiondestock.exception.ErrorCodes;
import com.rabii.gestiondestock.exception.InvalidEntityException;
import com.rabii.gestiondestock.mapper.FournisseurMapper;
import com.rabii.gestiondestock.model.Fournisseur;
import com.rabii.gestiondestock.repository.FournisseurRepository;
import com.rabii.gestiondestock.services.FournisseurService;
import com.rabii.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FournisseurServiceImpl implements FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    private final FournisseurMapper fournisseurMapper;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository, FournisseurMapper fournisseurMapper) {
        this.fournisseurRepository = fournisseurRepository;
        this.fournisseurMapper = fournisseurMapper;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validate(fournisseurDto);
        if(!errors.isEmpty()) {
            log.error("Fournisseur is not valid {}", fournisseurDto);
            throw new InvalidEntityException("L'Fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
        }
        return fournisseurMapper.modelToDto(
                fournisseurRepository.save(
                        fournisseurMapper.dtoToModel(fournisseurDto)
                )
        );
    }

    @Override
    public FournisseurDto findById(Integer idFournisseur) {
        if (idFournisseur == null) {
            log.error("Fournisseur ID is null");
            return null;
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(idFournisseur);
        return Optional.of(fournisseurMapper.modelToDto(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun fournisseur avec l'ID = " + idFournisseur + " n'est pas trouvé dans la BDD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND
                )
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                //.map(ArticleDto.class::cast)
                .map(fournisseur -> fournisseurMapper.modelToDto(fournisseur))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idFournisseur) {
        if (idFournisseur == null) {
            log.error("Fournisseur ID is null");
            return;
        }
        fournisseurRepository.deleteById(idFournisseur);
    }
}
