package com.scaler.blog_app.articles;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {

    ArticleRepository articleRepository;

    public ArticlesService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    void getAllArticle() {
        articleRepository.findAll();
    }

    void getArticleById(Long id) {
        articleRepository.findById(id);
    }

    List<ArticleEntity> findArticleBySlug(String slug) {
        return articleRepository.finArticleEntitiesBySlugContaining(slug);
    }

}
