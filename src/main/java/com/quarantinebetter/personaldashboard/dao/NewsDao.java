package com.quarantinebetter.personaldashboard.dao;

import com.quarantinebetter.personaldashboard.model.NewsArticle;

import java.util.List;
import java.util.UUID;

public interface NewsDao {
    List<NewsArticle> selectAllArticles();

    int deleteArticleById(UUID id);

    int addArticle(UUID id, NewsArticle article);
    
    default int addArticle(NewsArticle article) {
        UUID id = UUID.randomUUID();
        return addArticle(id, article);
    }
}
