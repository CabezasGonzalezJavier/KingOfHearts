package com.thedeveloperworldisyours.kinghearts.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.thedeveloperworldisyours.kinghearts.data.source.TopicsRepository;
import com.thedeveloperworldisyours.kinghearts.data.source.local.TopicsLocalDataSource;
import com.thedeveloperworldisyours.kinghearts.data.source.remote.TopicsRemoteDataSource;
import com.thedeveloperworldisyours.kinghearts.utils.scheduler.BaseSchedulerProvider;
import com.thedeveloperworldisyours.kinghearts.utils.scheduler.SchedulerProvider;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by javierg on 10/05/2017.
 */

public class Injection {

    public static TopicsRepository provideTasksRepository(@NonNull Context context) {
        checkNotNull(context);
        return TopicsRepository.getInstance(TopicsRemoteDataSource.getInstance(),
                TopicsLocalDataSource.getInstance(context, provideSchedulerProvider()));
    }

    public static BaseSchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
