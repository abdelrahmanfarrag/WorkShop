package com.example.mana.workshop.Helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mana.workshop.Activities.NewsDetails;
import com.example.mana.workshop.R;
import com.squareup.picasso.Picasso;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by MANA on 3/8/2018.
 */

public class Common  {

    public static void createSearch(final Context ctx, Menu menu)
    {
        SearchView searchView = (SearchView) menu.findItem(R.id.search_news).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                ToastMsg(ctx,s);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    /* NavigationDrawer selected*/
     public static void setSelectedImageVisbility(MenuItem item, ImageView selected)
    {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)item.getActionView().getLayoutParams();
        params.setMargins(0,0, RelativeLayout.ALIGN_PARENT_LEFT,0);
        //   params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.LEFT_OF,item.getItemId());
        selected.setLayoutParams(params);
        if (selected.getVisibility() == View.VISIBLE) {
            selected.setVisibility(View.GONE);
        }
        else {
            selected.setVisibility(View.VISIBLE);
        }
    }

    /* Performing implicit intent to browser to viewd full article details over website */
    public static void BrowserIntent (Context ctx,String url)
    {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        ctx.startActivity(i);
    }

    /* Create Toasts */
    public static void ToastMsg(Context ctx,String msg)
    {
        Toast.makeText(ctx,msg,Toast.LENGTH_SHORT).show();
    }

    /* Here attach the result data from json to views */
    public static void setViewsData(Context ctx,TextView Author_name, String Author, ImageView newsImage, String newsImageUrl
            , TextView newsTitle, String newsTitleString, TextView ViewDate, Date date)
    {
        Author_name.setText("By "+Author);
        Picasso.with(ctx).load(newsImageUrl).placeholder(R.mipmap.placeholder).into(newsImage);
        newsTitle.setText(newsTitleString);
        ViewDate.setText(TransformDate(date));
    }

    /* Transform Date object into String with format lat march 09,2018 .*/
    private static String TransformDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("LLLL MM ,yyyy", Locale.US) ;
        String dat = sdf.format(date);
        return dat;
    }
    /*
Pass the data from activity to another .
 */
    public static void DataIntent(Context ctx,String img,String title,String publisher,String desc,String url,Date date)
    {
        Intent intent = new Intent(ctx, NewsDetails.class);
        intent.putExtra("ImageUrl",img);
        intent.putExtra("Title",title);
        intent.putExtra("Publisher",publisher);
        intent.putExtra("desc",desc);
        intent.putExtra("NewsUrl",url);
        intent.putExtra("Date",date);
        ctx.startActivity(intent);
    }




}
