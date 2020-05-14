package com.quarantinebetter.personaldashboard.api;

import com.quarantinebetter.personaldashboard.model.NewsArticle;
import com.quarantinebetter.personaldashboard.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/news")
@RestController
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<NewsArticle> getAllNewsArticles() {
        return this.newsService.getAllArticles();
    }

}
