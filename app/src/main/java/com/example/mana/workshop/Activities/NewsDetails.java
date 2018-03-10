package com.example.mana.workshop.Activities;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mana.workshop.R;
import java.util.Date;
import static com.example.mana.workshop.Helper.Common.BrowserIntent;
import static com.example.mana.workshop.Helper.Common.createSearch;
import static com.example.mana.workshop.Helper.Common.setViewsData;

public class NewsDetails extends AppCompatActivity {
    private Toolbar details_bar;

    private TextView newsTitle,newsDate,newsAuthor,newsContent;
    private ImageView newsImage;
    private String newsTitle_value,newsImage_Url,newsAuthor_value,newsContent_value;
    private Date newsDate_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        details_bar= findViewById(R.id.details_bar);
        setSupportActionBar(details_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        newsTitle=findViewById(R.id.news_details_title);
        newsDate = findViewById(R.id.news_details_date);
        newsAuthor = findViewById(R.id.news_details_author);
        newsContent =findViewById(R.id.news_details_desc);
        newsImage =findViewById(R.id.news_details_image);
         newsTitle_value = getIntent().getExtras().getString("Title");
         newsDate_value = (Date) getIntent().getExtras().get("Date");
         newsImage_Url = getIntent().getExtras().getString("ImageUrl");
         newsAuthor_value = getIntent().getExtras().getString("Publisher");
         newsContent_value = getIntent().getExtras().getString("desc");
        setViewsData(getApplicationContext(),newsAuthor,newsAuthor_value,newsImage,newsImage_Url
         ,newsTitle,newsTitle_value,newsDate,newsDate_value);
         newsContent.setText(newsContent_value);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.options_menu,menu);
       createSearch(getApplicationContext(),menu);
        return true;
    }

    public void openUrl(View view) {
        String url = getIntent().getExtras().getString("NewsUrl");
        BrowserIntent(getApplicationContext(),url);

    }
}
