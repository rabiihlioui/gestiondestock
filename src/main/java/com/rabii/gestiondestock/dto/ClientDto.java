package com.rabii.gestiondestock.dto;

import com.rabii.gestiondestock.model.Adresse;
import com.rabii.gestiondestock.model.CommandeClient;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class ClientDto {
    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String mail;
    private String numTel;
    private List<CommandeClientDto> commandeClients;
}
