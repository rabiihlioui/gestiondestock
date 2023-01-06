package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Article;
import com.rabii.gestiondestock.model.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
public class LigneCommandeFournisseurDto {
    private Integer id;
    private ArticleDto article;
    private CommandeFournisseurDto commandeFournisseur;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}
