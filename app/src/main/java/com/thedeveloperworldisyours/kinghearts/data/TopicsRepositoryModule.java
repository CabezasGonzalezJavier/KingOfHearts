package com.thedeveloperworldisyours.kinghearts.data;

import android.content.Context;

import com.thedeveloperworldisyours.kinghearts.data.local.TopicsLocalDataSource;
import com.thedeveloperworldisyours.kinghearts.data.remote.TopicsRemoteDataSource;
import com.thedeveloperworldisyours.kinghearts.utils.scheduler.BaseSchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 09/05/2017.
 */
@Module
public class TopicsRepositoryModule {
    @Singleton
    @Provides
    @Local
    TopicsDataSource provideTopicsLocalDataSource(Context context, BaseSchedulerProvider schedulerProvider) {
        return new TopicsLocalDataSource(context, schedulerProvider);
    }

    @Singleton
    @Provides
    @Remote
    TopicsDataSource provideTopicsRemoteDataSource() {
        return new TopicsRemoteDataSource();
    }

}
