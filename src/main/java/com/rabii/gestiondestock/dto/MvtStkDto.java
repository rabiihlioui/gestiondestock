package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Article;
import com.rabii.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class MvtStkDto {
    private Integer id;
    private Instant dateMvt;
    private BigDecimal quantite;
    private Article article;
    private TypeMvtStk typeMvt;
}
