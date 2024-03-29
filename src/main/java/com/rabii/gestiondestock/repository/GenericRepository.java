package com.rabii.gestiondestock.repository;

import com.rabii.gestiondestock.model.AbstractEntity;
import com.rabii.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface GenericRepository<E extends AbstractEntity> extends JpaRepository<E, Integer> {
    //Optional<E> findByCodeArticle(String codeArticle);
}
