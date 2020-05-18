package com.quarantinebetter.personaldashboard.dao;

import com.quarantinebetter.personaldashboard.model.NewsArticle;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository("scraper")
public class NewsScraperDataAccessService implements NewsDao {
    private static List<NewsArticle> DB = new ArrayList<>();
    private final static String source = "CNN";
    private static String baseURL = "https://www.cnn.com/world/live-news/coronavirus-pandemic-%s-intl";
    private static String articleClass = "sc-cJSrbW poststyles__PostBox-sc-1egoi1-0 tzojb";

    @Override
    public List<NewsArticle> selectAllArticles() {
        scrapeWebsite();
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

    @Override
    public String getSource() {
        return source;
    }

    public void scrapeWebsite() {
        String url = String.format(baseURL, getCurrentDate());
        System.out.println(url);

        try {
            Document doc = Jsoup.connect(url + "/index.html").get();
            Elements elements = doc.getElementsByClass(articleClass);

            // Loop through articles and create NewsArticles
            for (Element e : elements) {
                String title = e.getElementsByTag("h2").text();
                String linkId = e.attr("id");
                String articleLink = url + "/" + linkId;
                if (title.length() > 0) {
                    UUID id = UUID.randomUUID();
                    NewsArticle article = new NewsArticle(id, articleLink, title);
                    DB.add(article);
                }
            }
        }
        catch (IOException e) {
            return;
        }
    }

    public String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yy");
        Date date = new Date();
        return sdf.format(date);
    }
}
