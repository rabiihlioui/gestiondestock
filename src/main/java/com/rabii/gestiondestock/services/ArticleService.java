package com.rabii.gestiondestock.services;

import com.rabii.gestiondestock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto articleDto);
    ArticleDto findById(Integer idArticle);
    ArticleDto findByCodeArticle(String codeArticle);
    List<ArticleDto> findAll();
    void delete(Integer idArticle);
}
