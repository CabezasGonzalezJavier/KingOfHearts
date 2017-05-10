package com.thedeveloperworldisyours.kinghearts.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import com.thedeveloperworldisyours.kinghearts.data.Topic;
import com.thedeveloperworldisyours.kinghearts.data.source.TopicsDataSource;
import com.thedeveloperworldisyours.kinghearts.utils.scheduler.BaseSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by javierg on 09/05/2017.
 */

public class TopicsLocalDataSource implements TopicsDataSource {

    @Nullable
    private static TopicsLocalDataSource INSTANCE;

    @NonNull
    private final BriteDatabase mDatabaseHelper;

    @NonNull
    private Func1<Cursor, Topic> mTopicsMapperFunction;


    // Prevent direct instantiation.
    public TopicsLocalDataSource(@NonNull Context context,
                                 @NonNull BaseSchedulerProvider schedulerProvider) {
        checkNotNull(context, "context cannot be null");
        checkNotNull(schedulerProvider, "scheduleProvider cannot be null");
        TopicsDbHelper dbHelper = new TopicsDbHelper(context);
        SqlBrite sqlBrite = SqlBrite.create();
        mDatabaseHelper = sqlBrite.wrapDatabaseHelper(dbHelper, schedulerProvider.io());
        mTopicsMapperFunction = (c) -> {
                String itemId = c.getString(c.getColumnIndexOrThrow(TopicsPersistenceContract.TopicsEntry.COLUMN_NAME_ENTRY_ID));
                String title = c.getString(c.getColumnIndexOrThrow(TopicsPersistenceContract.TopicsEntry.COLUMN_NAME_TITLE));
                return new Topic(Integer.valueOf(itemId), title);
        };


    }
    public static TopicsLocalDataSource getInstance(
            @NonNull Context context,
            @NonNull BaseSchedulerProvider schedulerProvider) {
        if (INSTANCE == null) {
            INSTANCE = new TopicsLocalDataSource(context, schedulerProvider);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public Observable<List<Topic>> getTopics() {
        String[] projection = {
                TopicsPersistenceContract.TopicsEntry.COLUMN_NAME_ENTRY_ID,
                TopicsPersistenceContract.TopicsEntry.COLUMN_NAME_TITLE
        };
        String sql = String.format("SELECT %s FROM %s", TextUtils.join(",", projection), TopicsPersistenceContract.TopicsEntry.TABLE_NAME);
        return mDatabaseHelper.createQuery(TopicsPersistenceContract.TopicsEntry.TABLE_NAME, sql)
                .mapToList(mTopicsMapperFunction);
    }

    @Override
    public void saveTopic(@NonNull Topic topic) {
        checkNotNull(topic);
        ContentValues values = new ContentValues();
        values.put(TopicsPersistenceContract.TopicsEntry.COLUMN_NAME_ENTRY_ID, String.valueOf(topic.getId()));
        values.put(TopicsPersistenceContract.TopicsEntry.COLUMN_NAME_TITLE, topic.getName());
        mDatabaseHelper.insert(TopicsPersistenceContract.TopicsEntry.TABLE_NAME, values, SQLiteDatabase.CONFLICT_REPLACE);
    }
}
