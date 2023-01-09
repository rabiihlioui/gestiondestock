package com.rabii.gestiondestock.repository;

import com.rabii.gestiondestock.model.AbstractEntity;
import com.rabii.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findByCodeArticle(String codeArticle);
}
