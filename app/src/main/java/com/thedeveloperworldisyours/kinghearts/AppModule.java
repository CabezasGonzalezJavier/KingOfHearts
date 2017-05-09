package com.thedeveloperworldisyours.kinghearts;

import android.content.Context;

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

    private final Context mContext;

    AppModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    BaseSchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }
}
