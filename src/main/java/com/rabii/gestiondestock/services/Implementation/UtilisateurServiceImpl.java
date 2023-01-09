package com.rabii.gestiondestock.services.Implementation;

import com.rabii.gestiondestock.dto.UtilisateurDto;
import com.rabii.gestiondestock.dto.UtilisateurDto;
import com.rabii.gestiondestock.exception.EntityNotFoundException;
import com.rabii.gestiondestock.exception.ErrorCodes;
import com.rabii.gestiondestock.exception.InvalidEntityException;
import com.rabii.gestiondestock.mapper.UtilisateurMapper;
import com.rabii.gestiondestock.model.Utilisateur;
import com.rabii.gestiondestock.repository.UtilisateurRepository;
import com.rabii.gestiondestock.services.UtilisateurService;
import com.rabii.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    private final UtilisateurMapper utilisateurMapper;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDto);
        if(!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", utilisateurDto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }
        return utilisateurMapper.modelToDto(
                utilisateurRepository.save(
                        utilisateurMapper.dtoToModel(utilisateurDto)
                )
        );
    }

    @Override
    public UtilisateurDto findById(Integer idUtilisateur) {
        if (idUtilisateur == null) {
            log.error("Utilisateur ID is null");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(idUtilisateur);
        return Optional.of(utilisateurMapper.modelToDto(utilisateur.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + idUtilisateur + " n'est pas trouvé dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND
                )
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                //.map(ArticleDto.class::cast)
                .map(utilisateur -> utilisateurMapper.modelToDto(utilisateur))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idUtilisateur) {
        if (idUtilisateur == null) {
            log.error("Utilisateur ID is null");
            return;
        }
        utilisateurRepository.deleteById(idUtilisateur);
    }
}
