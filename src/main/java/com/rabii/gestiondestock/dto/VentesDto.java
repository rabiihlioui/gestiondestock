package com.rabii.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import java.time.Instant;

@Data
public class VentesDto {
    private Integer id;
    private String code;
    private Instant dateVente;
    private  String commentaire;
}
