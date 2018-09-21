package com.playground.ui.savenote

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.playground.Injection
import com.playground.NoteApplication
import com.playground.R
import com.playground.entities.NoteEntry
import com.playground.utils.isValidTextInput
import kotlinx.android.synthetic.main.layout_create_note.view.*

class SaveNoteView : BottomSheetDialogFragment() {


    private var factory: SaveNoteViewModelFactory? = null
    private var viewModel: SaveNoteViewModel? = null
    private var layout: View? = null
    private var noteId: Int = NoteEntry.DEFAULT_ID


    private val listenerSave = View.OnClickListener {

        val title = layout!!.inputNoteTitle.text.toString()
        val description = layout!!.inputNoteDesc.text.toString()

        if (isValidTextInput(title) &&
                isValidTextInput(description)) {

            saveNote(title, description)
        }
    }

    private fun saveNote(title: String, description: String) {
        if (noteId != NoteEntry.DEFAULT_ID) {
            viewModel!!.update(NoteEntry(noteId, title, description))
        } else {
            viewModel!!.insert(NoteEntry(noteId, title, description))
        }
        dismiss()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(DialogFragment.STYLE_NO_FRAME, 0)
        noteId = arguments!!.getInt(NoteEntry.DATA)

        viewModel = ViewModelProviders.of(this, Injection.provideSaveNoteViewModelFactory(NoteApplication.getInstance())).get(SaveNoteViewModel::class.java)

        viewModel?.getNoteEntry(noteId)?.observe(this, Observer { populateData(it) })
    }

    private fun populateData(noteEntry: NoteEntry?) {
        view?.inputNoteTitle?.setText(noteEntry?.title)
        view?.inputNoteDesc?.setText(noteEntry?.description)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        layout = inflater.inflate(R.layout.layout_create_note, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout?.btnSave?.setOnClickListener(listenerSave)
    }


    companion object {
        val TAG = "save_note"
        fun newInstance(noteId: Int): SaveNoteView =
                SaveNoteView().apply {
                    arguments = Bundle().apply {
                        putInt(NoteEntry.DATA, noteId)
                    }
                }
    }
}
