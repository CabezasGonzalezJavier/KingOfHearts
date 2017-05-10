package com.thedeveloperworldisyours.kinghearts;

import android.content.Context;

import com.thedeveloperworldisyours.kinghearts.data.source.TopicsDataSource;
import com.thedeveloperworldisyours.kinghearts.data.source.local.TopicsLocalDataSource;
import com.thedeveloperworldisyours.kinghearts.data.source.remote.TopicsRemoteDataSource;
import com.thedeveloperworldisyours.kinghearts.utils.scheduler.BaseSchedulerProvider;
import com.thedeveloperworldisyours.kinghearts.utils.scheduler.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 09/05/2017.
 */
@Module
public class AppModule {

    KingHeartsApplication mApplication;

    AppModule(KingHeartsApplication application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    TopicsDataSource provideTopicsLocalDataSource(Context context) {
        return new TopicsLocalDataSource(context, provideSchedulerProvider());
    }

    @Singleton
    @Provides
    TopicsDataSource provideTasksRemoteDataSource() {
        return new TopicsRemoteDataSource();
    }


    @Singleton
    @Provides
    BaseSchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }

}
