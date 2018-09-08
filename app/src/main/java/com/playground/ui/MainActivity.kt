package com.playground.ui

import android.arch.lifecycle.LiveData
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.playground.R
import com.playground.database.NoteEntry
import com.playground.ui.noteslist.AdapterNotes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var listenerAddNote = View.OnClickListener {
        Snackbar.make(it.rootView, "Add Item", Snackbar.LENGTH_LONG).show()
    }

    lateinit var adapterNotes: AdapterNotes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val mDb = AppDatabase.getInstance(this)
//        mDb.noteDao().insertNote(NoteEntry())

        bntAddNote.setOnClickListener(listenerAddNote)

        val notesEntries = ArrayList<NoteEntry>()


        for (i in 1..10) {
            val noteEntry = NoteEntry()
            noteEntry.title = "Note ${i}"
            notesEntries.add(noteEntry)

        }
        adapterNotes = AdapterNotes(this, notesEntries)
        rvListNotes.adapter = adapterNotes

    }


    fun retrieveNotes() {
        var notesList: LiveData<NoteEntry>
    }
}
