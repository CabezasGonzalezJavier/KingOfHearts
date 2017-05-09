package com.thedeveloperworldisyours.kinghearts.data.local;

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.squareup.sqlbrite.BriteDatabase;
import com.thedeveloperworldisyours.kinghearts.data.Topics;
import com.thedeveloperworldisyours.kinghearts.data.TopicsDataSource;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by javierg on 09/05/2017.
 */

public class TopicsLocalDataSource implements TopicsDataSource {

    @NonNull
    private final BriteDatabase mDatabaseHelper;

    @NonNull
    private Func1<Cursor, Topics> mTopicsMapperFunction;

    @Override
    public Observable<List<Topics>> getTasks() {
        return null;
    }
}
