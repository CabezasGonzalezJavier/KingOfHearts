package com.thedeveloperworldisyours.kinghearts.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by javierg on 09/05/2017.
 */

public class TopicsPersistenceContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public TopicsPersistenceContract() {
    }

    public static abstract  class TopicsEntry implements BaseColumns {
        public static final String TABLE_NAME = "topics";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
    }
}
