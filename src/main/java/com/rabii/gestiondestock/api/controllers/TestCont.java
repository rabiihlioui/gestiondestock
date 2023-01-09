package com.rabii.gestiondestock.api.controllers;

import com.rabii.gestiondestock.model.Article;
import com.rabii.gestiondestock.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCont {
    @Autowired
    private GenericRepository<Article> articleRepo;

    public void testMethod() {
        this.articleRepo.findAll();
    }
}
