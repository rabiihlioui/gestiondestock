package com.rabii.gestiondestock.mapper;

import com.rabii.gestiondestock.dto.CategoryDto;
import com.rabii.gestiondestock.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto modelToDto(Category Category);
    Category dtoToModel(CategoryDto CategoryDto);
    List<CategoryDto> modelsToDtos(List<Category> Categorys);
    List<Category> dtosToModels(List<CategoryDto> CategoryDtos);
}
