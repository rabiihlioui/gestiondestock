package com.rabii.gestiondestock.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "idVente")
    private Ventes vente;
    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Article article;
    @Column(name = "quantite")
    private BigDecimal quantite;
    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;
    @Column(name = "identreprise")
    private Integer idEntreprise;
}
