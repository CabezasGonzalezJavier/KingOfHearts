package com.thedeveloperworldisyours.kinghearts;

import android.app.Application;

import com.thedeveloperworldisyours.kinghearts.data.TopicsRepositoryComponent;

/**
 * Created by javierg on 09/05/2017.
 */

public class KingHeartsApplication extends Application{

    private TopicsRepositoryComponent mRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mRepositoryComponent = DaggerTopicsRepositoryComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();

    }

    public TopicsRepositoryComponent getTopicsRepositoryComponent() {
        return mRepositoryComponent;
    }
}
