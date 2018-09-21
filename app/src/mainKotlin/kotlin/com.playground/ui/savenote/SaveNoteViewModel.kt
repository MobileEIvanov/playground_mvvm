package com.playground.ui.savenote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.playground.data.RepositoryNotes
import com.playground.entities.NoteEntry

/**
 * Created by emil.ivanov on 9/9/18.
 */
class SaveNoteViewModel(val repository: RepositoryNotes) : ViewModel() {

    var noteEntry: LiveData<NoteEntry> = MutableLiveData<NoteEntry>()


    fun getNoteEntry(id: Long): LiveData<NoteEntry> {
        if (this.noteEntry == null) {
            this.noteEntry = repository.loadNoteById(id)
        }
        return this.noteEntry
    }

    fun insert(noteEntry: NoteEntry) {
        repository.insertNote(noteEntry)
    }

    fun update(noteEntry: NoteEntry) {
        repository.updateNote(noteEntry)
    }
}
