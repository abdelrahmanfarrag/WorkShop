package com.example.mana.workshop.Fragments;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mana.workshop.Adapters.NewsAdapter;
import com.example.mana.workshop.Interfaces.news;
import com.example.mana.workshop.Models.NewsData_Model;
import com.example.mana.workshop.Presenters.NewsPresenter;
import com.example.mana.workshop.R;
import java.util.List;

/**
 * Created by MANA on 3/8/2018.
 */

public class NewsFragment extends Fragment implements news{
    View v;
    NewsPresenter presenter;
    private RecyclerView newsView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.news_fragment,container,false);
        presenter = new NewsPresenter(getActivity(),this);
        newsView= v.findViewById(R.id.news_view);
        newsView.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsView.setHasFixedSize(true);
        presenter.LoadNews();
        return v;
    }
    @Override
    public void getNews(List<NewsData_Model.Articles> articles) {
        newsView.setAdapter(new NewsAdapter(getActivity(),articles));
    }
}
