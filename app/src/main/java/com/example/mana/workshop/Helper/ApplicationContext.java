package com.example.mana.workshop.Helper;

import android.app.Application;
import android.content.Context;

/**
 * Created by MANA on 3/8/2018.
 */

public class ApplicationContext extends Application {
    private static ApplicationContext context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
    public static ApplicationContext getContext()
    {
        return context;
    }
    public static Context getAppContext()
    {
        return context.getApplicationContext();
    }


}