package com.quarantinebetter.personaldashboard.model;

import java.util.UUID;

public class NewsArticle {
    private final UUID id;
    private final String link;
    private final String title;

    public NewsArticle(UUID id, String link, String title) {
        this.id = id;
        this.link = link;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }
}
