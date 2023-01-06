package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
public class LigneVenteDto {
    private Integer id;
    private VentesDto vente;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
}
