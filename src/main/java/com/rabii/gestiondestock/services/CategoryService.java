package com.rabii.gestiondestock.services;

import com.rabii.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto CategoryDto);
    CategoryDto findById(Integer idCategory);
    CategoryDto findByCode(String code);
    List<CategoryDto> findAll();
    void delete(Integer idCategory);
}
