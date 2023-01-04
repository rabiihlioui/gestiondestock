package com.rabii.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // this annotation will automatically listen to the current class and every there is createdDate and lastModifiedDate
                                               // it will update their attributes just before saving the entity in the DB
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue //by default AUTO
    private Integer id;
    @CreatedDate
    @Column(name="creationDate", nullable = false)
    @JsonIgnore
    private Instant creationDate;
    @LastModifiedDate
    @Column(name="lastModifiedDate")
    @JsonIgnore
    private Instant lastUpdateDate;
}
