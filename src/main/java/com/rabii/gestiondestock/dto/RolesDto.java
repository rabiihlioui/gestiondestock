package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class RolesDto {
    private Integer id;
    private String roleName;
    private UtilisateurDto utilisateur;
}
