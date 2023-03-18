package com.scaler.blog_app.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
//    we can write custom query like that
//    @Query("select article from articles where slug = slug)
//    List<ArticleEntity> finArticleEntityBySlugContaining(String slug);

    List<ArticleEntity> finArticleEntitiesBySlugContaining(String slug);

}
