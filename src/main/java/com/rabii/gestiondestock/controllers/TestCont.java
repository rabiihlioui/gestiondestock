package com.rabii.gestiondestock.controllers;

import com.rabii.gestiondestock.model.Article;
import com.rabii.gestiondestock.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCont {
    @Autowired
    private GenericRepository<Article, Integer> articleRepo;

    public void testMethod() {
        this.articleRepo.findAll();
    }
}
