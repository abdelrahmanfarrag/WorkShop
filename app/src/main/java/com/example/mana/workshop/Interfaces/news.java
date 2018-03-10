package com.example.mana.workshop.Interfaces;

import com.example.mana.workshop.Models.NewsData_Model;

import java.util.List;

/**
 * Created by MANA on 3/8/2018.
 */

public interface news {

    void getNews(List<NewsData_Model.Articles> articles);

}
