package com.rabii.gestiondestock.validator;

import com.rabii.gestiondestock.dto.CategoryDto;
import com.rabii.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();
        if(utilisateurDto == null) {
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
            return errors;
        }
        if(!StringUtils.hasLength(utilisateurDto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getEmail())) {
            errors.add("Veuillez renseigner l'email de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
        }
        if(utilisateurDto.getDateDeNaissance() == null) {
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
        }
        if(utilisateurDto.getAdresse() == null) {
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
        } else {
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
                errors.add("le champs 'adresse 1' est obligatoir");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
                errors.add("le champs 'ville' est obligatoir");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
                errors.add("le champs 'code postale' est obligatoir");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
                errors.add("le champs 'pays' est obligatoir");
            }
        }
        return errors;
    }
}
