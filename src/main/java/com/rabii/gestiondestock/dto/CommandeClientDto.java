package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Client;
import com.rabii.gestiondestock.model.LigneCommandeClient;
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
public class CommandeClientDto {
    private Integer id;
    private String code;
    private Instant dateCommande;
    private ClientDto client;
    private List<LigneCommandeClientDto> ligneCommandeClients;
}
