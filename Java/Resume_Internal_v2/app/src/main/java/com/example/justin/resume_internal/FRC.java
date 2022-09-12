package com.example.justin.resume_internal;

import android.provider.BaseColumns;

/**
 * Created by Justin on 7/11/2016.
 */
public final class FRC {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FRC() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "FULL_NAME";
        public static final String FIRST_NAME = "first_name";
        public static final String MIDDLE_NAME = "middle_name";
        public static final String LAST_NAME = "last_name";
        public static final String COLUMN_NAME_NULLABLE = null;
        public static final String COLUMN_NAME_UPDATED = "?";
    }
}
