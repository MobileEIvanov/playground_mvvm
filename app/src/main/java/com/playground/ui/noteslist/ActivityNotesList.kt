package com.playground.ui.noteslist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.playground.Injection
import com.playground.R
import com.playground.entities.NoteEntry
import com.playground.ui.savenote.SaveNoteView
import kotlinx.android.synthetic.main.activity_main.*

class ActivityNotesList : AppCompatActivity() {


    var viewModel: NoteListViewModel? = null
    private lateinit var adapterNotes: AdapterNotesKt
    var listenerAddNote = View.OnClickListener {

        showSaveDialog(NoteEntry.DEFAULT_ID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
        loadData()
    }


    private fun initialize() {
        viewModel = ViewModelProviders.of(this, Injection.provideNotesListViewModelFactory(this))
                .get(NoteListViewModel::class.java)
        adapterNotes = AdapterNotesKt(this::onNoteClickInteraction, this::onNoteDeleteInteraction)
        rvListNotes.adapter = adapterNotes

        bntAddNote.setOnClickListener(listenerAddNote)
    }

    private fun loadData() {
        viewModel?.notes?.observe(this, Observer {

            showEmptyList(it?.size == 0)
            adapterNotes.submitList(it)
        })
    }

    private fun showEmptyList(show: Boolean) {
        if (show) {
            emptyList.visibility = View.VISIBLE
            rvListNotes.visibility = View.GONE
        } else {
            emptyList.visibility = View.GONE
            rvListNotes.visibility = View.VISIBLE
        }
    }


    private fun onNoteClickInteraction(noteEntry: NoteEntry) {
        showSaveDialog(noteEntry.id)
    }


    private fun onNoteDeleteInteraction(noteEntry: NoteEntry) {
        viewModel?.delete(noteEntry)
    }

    private fun showSaveDialog(noteId: Int) {
        var dialog: Fragment? = supportFragmentManager.findFragmentByTag(SaveNoteView.TAG)
        if (dialog == null) {
            dialog = SaveNoteView.newInstance(noteId)
        }
        if (!dialog.isVisible) {
            (dialog as SaveNoteView).show(supportFragmentManager, SaveNoteView.TAG)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel!!.notes.removeObservers(this)
    }

}
