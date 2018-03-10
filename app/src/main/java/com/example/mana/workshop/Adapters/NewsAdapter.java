package com.example.mana.workshop.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mana.workshop.Models.NewsData_Model;
import com.example.mana.workshop.R;
import java.util.List;
import static com.example.mana.workshop.Helper.Common.DataIntent;
import static com.example.mana.workshop.Helper.Common.setViewsData;

/**
 * Created by MANA on 3/8/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    List<NewsData_Model.Articles> articlesList;
    View v;
    Context c;
    public NewsAdapter(Context c,List<NewsData_Model.Articles> articlesList)
    {
        this.c=c;
        this.articlesList=articlesList;
    }
    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         v = LayoutInflater.from(c).inflate(R.layout.single_news,parent,false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {

        final NewsData_Model.Articles Article_atPosition = articlesList.get(position);

       setViewsData(c,holder.author,Article_atPosition.getAuthor(),holder.newsImage,Article_atPosition.getNews_url()
       ,holder.title,Article_atPosition.getTitle(),holder.newsDate,Article_atPosition.getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataIntent(c,Article_atPosition.getNews_url(),Article_atPosition.getTitle(),Article_atPosition.getAuthor()
                        ,Article_atPosition.getDesc(),Article_atPosition.getUrl(),Article_atPosition.getDate());

            }
        });

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder
    {
        private TextView title,author,newsDate;
        private ImageView newsImage;

        public NewsHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.news_title);
            author= itemView.findViewById(R.id.news_publisher);
            newsDate= itemView.findViewById(R.id.news_date);
            newsImage= itemView.findViewById(R.id.news_image);
        }
    }
}
