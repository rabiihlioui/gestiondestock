package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Article;
import com.rabii.gestiondestock.model.CommandeClient;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
public class LigneCommandeClientDto {
    private Integer id;
    private ArticleDto article;
    private CommandeClientDto commandeClient;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}
