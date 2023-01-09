package com.rabii.gestiondestock.services.Implementation;

import com.rabii.gestiondestock.dto.ArticleDto;
import com.rabii.gestiondestock.dto.CategoryDto;
import com.rabii.gestiondestock.exception.EntityNotFoundException;
import com.rabii.gestiondestock.exception.ErrorCodes;
import com.rabii.gestiondestock.exception.InvalidEntityException;
import com.rabii.gestiondestock.mapper.CategoryMapper;
import com.rabii.gestiondestock.model.Article;
import com.rabii.gestiondestock.model.Category;
import com.rabii.gestiondestock.repository.CategoryRepository;
import com.rabii.gestiondestock.services.CategoryService;
import com.rabii.gestiondestock.validator.ArticleValidator;
import com.rabii.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()) {
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("La category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return categoryMapper.modelToDto(
                categoryRepository.save(
                        categoryMapper.dtoToModel(categoryDto)
                )
        );
    }

    @Override
    public CategoryDto findById(Integer idCategory) {
        if (idCategory == null) {
            log.error("Category ID is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(idCategory);
        return Optional.of(categoryMapper.modelToDto(category.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune categorie avec l'ID = " + idCategory + " n'est pas trouvé dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (code == null) {
            log.error("Category CODE is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findCategoryByCode(code);
        return Optional.of(categoryMapper.modelToDto(category.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune categorie avec le code = " + code + " n'est pas trouvé dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND
                )
        );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                //.map(ArticleDto.class::cast)
                .map(category -> categoryMapper.modelToDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idCategory) {
        if (idCategory == null) {
            log.error("Category ID is null");
            return;
        }
        categoryRepository.deleteById(idCategory);
    }
}
