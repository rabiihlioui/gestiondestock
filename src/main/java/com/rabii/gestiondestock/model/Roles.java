package com.rabii.gestiondestock.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity {
    @Column(name = "rolename")
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;
    @Column(name = "identreprise")
    private Integer idEntreprise;
}
