package com.playground

import android.arch.lifecycle.LiveData
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.playground.database.AppDatabase
import com.playground.database.NoteEntry

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mDb = AppDatabase.getInstance(this)
        mDb.noteDao().insertNote(NoteEntry())


        // TODO 1. Make the insert queries on new thread.
        // TODO 2. List the Notes
    }


    fun retrieveNotes() {
        var notesList: LiveData<NoteEntry>
    }
}
