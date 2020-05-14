package com.quarantinebetter.personaldashboard.dao;

import com.quarantinebetter.personaldashboard.model.NewsArticle;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Qualifier("scraper")
public class NewsScraperDataAccessService implements NewsDao {
    private static List<NewsArticle> DB = new ArrayList<>();

    @Override
    public List<NewsArticle> selectAllArticles() {
        return DB;
    }

    @Override
    public int deleteArticleById(UUID id) {
        return 0;
    }

    @Override
    public int addArticle(UUID id, NewsArticle article) {
        DB.add(new NewsArticle(id, article.getLink(), article.getTitle()));
        return 0;
    }


}
