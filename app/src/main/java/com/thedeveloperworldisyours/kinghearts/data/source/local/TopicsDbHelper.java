package com.thedeveloperworldisyours.kinghearts.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by javierg on 09/05/2017.
 */

public class TopicsDbHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Topic.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TopicsPersistenceContract.TopicsEntry.TABLE_NAME + " (" +
                    TopicsPersistenceContract.TopicsEntry._ID + TEXT_TYPE + " PRIMARY KEY," +
                    TopicsPersistenceContract.TopicsEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    TopicsPersistenceContract.TopicsEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    " )";

    public TopicsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
