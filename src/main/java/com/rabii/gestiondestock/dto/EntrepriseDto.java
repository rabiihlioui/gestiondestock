package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Adresse;
import com.rabii.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class EntrepriseDto {
    private Integer id;
    private String nom;
    private String description;
    private Adresse adresse;
    private String codeFiscal;
    private String photo;
    private String email;
    private String numTel;
    private String siteWeb;
    private List<UtilisateurDto> utilisateurs;
}
