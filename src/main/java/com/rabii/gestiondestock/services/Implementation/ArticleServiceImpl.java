package com.rabii.gestiondestock.services.Implementation;

import com.rabii.gestiondestock.dto.ArticleDto;
import com.rabii.gestiondestock.exception.EntityNotFoundException;
import com.rabii.gestiondestock.exception.ErrorCodes;
import com.rabii.gestiondestock.exception.InvalidEntityException;
import com.rabii.gestiondestock.mapper.GenericMapper;
import com.rabii.gestiondestock.model.Article;
import com.rabii.gestiondestock.repository.GenericRepository;
import com.rabii.gestiondestock.services.ArticleService;
import com.rabii.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    private GenericRepository<Article, Integer> articleRepository;

    private GenericMapper<ArticleDto, Article> articleMapper;

    @Autowired
    public ArticleServiceImpl(GenericRepository<Article, Integer> articleRepository,
                              GenericMapper<ArticleDto, Article> articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()) {
            log.error("Articl is not valid {}", articleDto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return articleMapper.modelToDto(
                articleRepository.save(
                        articleMapper.dtoToModel(articleDto)
                )
        );
    }

    @Override
    public ArticleDto findById(Integer idArticle) {
        if (idArticle == null) {
            log.error("Articl ID is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(idArticle);
        return Optional.of(articleMapper.modelToDto(article.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + idArticle + " n'est pas trouvé dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(StringUtils.hasLength(codeArticle)) {
            log.error("Artical code is null");
            return null;
        }
        Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);
        return Optional.of(articleMapper.modelToDto(article.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec le code article = " + codeArticle + " n'est pas trouvé dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(articleMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idArticle) {
        if (idArticle == null) {
            log.error("Articl ID is null");
            return;
        }
        articleRepository.deleteById(idArticle);
    }
}
