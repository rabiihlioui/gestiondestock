package com.rabii.gestiondestock.mapper;

import com.rabii.gestiondestock.dto.ArticleDto;
import com.rabii.gestiondestock.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring")
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    //@Mapping(source = "E", target = "code")
    ArticleDto modelToDto(Article article);
    //@InheritInverseConfiguration
    Article dtoToModel(ArticleDto articleDto);
    List<ArticleDto> modelsToDtos(List<Article> articles);
    List<Article> dtosToModels(List<ArticleDto> articleDtos);
}