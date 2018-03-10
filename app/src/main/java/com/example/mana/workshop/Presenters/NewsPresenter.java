package com.example.mana.workshop.Presenters;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import com.example.mana.workshop.Interfaces.news;
import com.example.mana.workshop.Models.NewsData_Model;

import com.example.mana.workshop.Helper.ApplicationSingleton;
import com.google.gson.Gson;

import static com.example.mana.workshop.Helper.Common.ToastMsg;


/**
 * Created by MANA on 3/8/2018.
 */

public class NewsPresenter {
    Context ctx;
    private news get_news;
    private RequestQueue rQueue;
    private StringRequest Load_News;

    public NewsPresenter(Context ctx, news get_news)
    {
        this.ctx=ctx;
        this.get_news=get_news;
    }
    // This method is performing connect to  NewsApi URl
    public void LoadNews()
    {
      String url = "https://newsapi.org/v1/articles?source=the-next-web&apiKey=533af958594143758318137469b41ba9";
        Load_News = new StringRequest(Request.Method.GET,url,Success,Error);
        rQueue = ApplicationSingleton.getInstance().getQueue();
        rQueue.add(Load_News);


    }
    /*When Connection is Successfully accomplished ,Then transform JSon object which is response into readable format
       usign GSON and then load data into interface to pass them to the view .
     */
    private Response.Listener<String> Success = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

                Gson NewsJSONTranform = new Gson();
                NewsData_Model article_model = NewsJSONTranform.fromJson(response,NewsData_Model.class);
                get_news.getNews(article_model.getArticles());
        }
    };
    /*
    If Connection is failed for any reason then , make a toast with error reason .
     */
private Response.ErrorListener Error = new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        ToastMsg(ctx,error.toString());
    }
};







}
