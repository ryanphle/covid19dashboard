package com.quarantinebetter.personaldashboard.service;

import com.quarantinebetter.personaldashboard.dao.NewsDao;
import com.quarantinebetter.personaldashboard.model.NewsArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsDao newsDao;

    @Autowired
    public NewsService(@Qualifier("scraper") NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public List<NewsArticle> getAllArticles() {
        return newsDao.selectAllArticles();
    }
}
