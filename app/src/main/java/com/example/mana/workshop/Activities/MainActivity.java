package com.example.mana.workshop.Activities;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.example.mana.workshop.R;
import static com.example.mana.workshop.Helper.Common.ToastMsg;
import static com.example.mana.workshop.Helper.Common.createSearch;
import static com.example.mana.workshop.Helper.Common.setSelectedImageVisbility;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mView;
    private Toolbar mTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTool = findViewById(R.id.my_bar);
        setSupportActionBar(mTool);
        mLayout = findViewById(R.id.drawer_layout);
        mView = findViewById(R.id.main_actvitiy_navigation);
        mView.getBackground().setAlpha(240);

        mToggle = new ActionBarDrawerToggle(this,mLayout,R.string.open,R.string.close);
        mLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        mView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.colorAccent));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        createSearch(getApplicationContext(),menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        ImageView selected = (ImageView) MenuItemCompat.getActionView(mView.getMenu().findItem(item.getItemId()));
        selected.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        selected.setBackgroundResource(R.mipmap.selected);
        switch (item.getItemId())
        {
            case R.id.live_chat :
                ToastMsg(getApplicationContext(),"Live Chat");
               setSelectedImageVisbility(item,selected);
                break;
            case R.id.explore :
                ToastMsg(getApplicationContext(),"Explore");
                setSelectedImageVisbility(item,selected);
                break;
            case R.id.navigation_gallery :
                ToastMsg(getApplicationContext(),"Gallery");
                setSelectedImageVisbility(item,selected);
                break;
            case R.id.navigation_wish :
               ToastMsg(getApplicationContext(),"Wish List");
                setSelectedImageVisbility(item,selected);
                break;
            case R.id.navigation_magazines :
                ToastMsg(getApplicationContext(),"E-Magazines");
                setSelectedImageVisbility(item,selected);
                break;
        }
        return false;
    }



}
