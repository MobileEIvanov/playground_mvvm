package com.playground.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.playground.entities.NoteEntry

/**
 *
 */
@Database(entities = [NoteEntry::class], version = 1, exportSchema = false)
@TypeConverters(DateConverterKt::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteEntryDao

    companion object {
        const val DATABASE_NAME = "notes_app"

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .build()
        }
    }


}
