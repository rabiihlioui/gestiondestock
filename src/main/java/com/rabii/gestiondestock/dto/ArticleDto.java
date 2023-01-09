package com.rabii.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rabii.gestiondestock.model.Article;
import com.rabii.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
public class ArticleDto {
    private Integer id;
    private String codeArticle;
    private String designation;
    private BigDecimal prixUnitaireHT;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private String photo;
    private CategoryDto category;

    /*public ArticleDto fromEntity(Article article) {
        if(article == null) {
            return null;
            // throw exception
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHT(article.getPrixUnitaireHT())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .build();
    }

    public Article toEntity(ArticleDto articleDto) {
        if(articleDto == null) {
            return null;
            // throw exception
        }
        return Article.builder()
                .id(articleDto.getId())
                .codeArticle(articleDto.getCodeArticle())
                .designation(articleDto.getDesignation())
                .prixUnitaireHT(articleDto.getPrixUnitaireHT())
                .tauxTva(articleDto.getTauxTva())
                .prixUnitaireTtc(articleDto.getPrixUnitaireTtc())
                .photo(articleDto.getPhoto())
                .build();
    }*/
}
