package com.thedeveloperworldisyours.kinghearts;

import android.app.Application;

/**
 * Created by javierg on 09/05/2017.
 */

public class KingHeartsApplication extends Application{

    AppComponent mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

    }
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
