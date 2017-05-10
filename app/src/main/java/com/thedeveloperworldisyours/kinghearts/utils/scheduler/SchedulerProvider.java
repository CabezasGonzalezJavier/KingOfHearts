package com.thedeveloperworldisyours.kinghearts.utils.scheduler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.thedeveloperworldisyours.kinghearts.utils.scheduler.BaseSchedulerProvider;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by javierg on 20/02/2017.
 */

public class SchedulerProvider implements BaseSchedulerProvider {


    @Nullable
    private static SchedulerProvider INSTANCE;
    // Prevent direct instantiation.
    public SchedulerProvider() {
    }

    public static synchronized SchedulerProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SchedulerProvider();
        }
        return INSTANCE;
    }

    @Override
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
