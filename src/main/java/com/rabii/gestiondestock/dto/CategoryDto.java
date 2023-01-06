package com.rabii.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rabii.gestiondestock.model.Article;
import com.rabii.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class CategoryDto {
    private Integer id;
    private String code;
    private String designation;
    @JsonIgnore
    private List<ArticleDto> articles;

    /*public CategoryDto fromEntity(Category category) {
        if(category == null) {
            return null;
            // throw exception
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public Category toEntity(CategoryDto categoryDto) {
        if(categoryDto == null) {
            return null;
            // throw exception
        }
        return Category.builder()
                .id(categoryDto.getId())
                .code(categoryDto.getCode())
                .designation(categoryDto.getDesignation())
                .build();
    }*/
}
