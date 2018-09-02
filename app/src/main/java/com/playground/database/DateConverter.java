package com.playground.database;

import android.arch.persistence.room.TypeConverter;

import java.sql.Date;

/**
 * Created by emil.ivanov on 9/2/18.
 */
public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
