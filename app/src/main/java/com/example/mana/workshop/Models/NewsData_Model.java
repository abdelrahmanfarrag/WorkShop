package com.example.mana.workshop.Models;

import com.google.gson.annotations.SerializedName;

import java.lang.ref.PhantomReference;
import java.util.Date;
import java.util.List;

/**
 * Created by MANA on 3/8/2018.
 */

public class NewsData_Model {
    @SerializedName("status")
    private String status;
    @SerializedName("source")
    private String source;
    @SerializedName("sortBy")
    private String sort_by;
    @SerializedName("articles")
    private List<Articles> articles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSort_by() {
        return sort_by;
    }

    public void setSort_by(String sort_by) {
        this.sort_by = sort_by;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public class Articles{
        @SerializedName("author")
        private String author;
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String desc;
        @SerializedName("url")
        private String url;
        @SerializedName("urlToImage")
        private String news_url;
        @SerializedName("publishedAt")
        private Date date;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNews_url() {
            return news_url;
        }

        public void setNews_url(String news_url) {
            this.news_url = news_url;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

}
