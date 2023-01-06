package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Fournisseur;
import com.rabii.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
public class CommandeFournisseurDto {
    private Integer id;
    private String code;
    private Instant dateCommande;
    private FournisseurDto fournisseur;
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;
}
