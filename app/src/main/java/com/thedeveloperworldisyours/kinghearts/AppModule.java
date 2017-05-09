package com.thedeveloperworldisyours.kinghearts;

import com.thedeveloperworldisyours.kinghearts.utils.BaseSchedulerProvider;
import com.thedeveloperworldisyours.kinghearts.utils.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 09/05/2017.
 */
@Module
public class AppModule {

    KingHeartsApplication mApplication;

    public AppModule(KingHeartsApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    BaseSchedulerProvider provideScheduler() {
        return new SchedulerProvider();
    }


}
