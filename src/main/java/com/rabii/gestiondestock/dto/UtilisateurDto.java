package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Adresse;
import com.rabii.gestiondestock.model.Entreprise;
import com.rabii.gestiondestock.model.Roles;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Data
public class UtilisateurDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Instant dateDeNaissance;
    private String motDePasse;
    private Adresse adresse;
    private String photo;
    private EntrepriseDto entreprise;
    private List<RolesDto> roles;
}
