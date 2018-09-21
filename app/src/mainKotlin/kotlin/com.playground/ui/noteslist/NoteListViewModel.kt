package com.playground.ui.noteslist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.playground.data.RepositoryNotes
import com.playground.entities.NoteEntry

/**
 * Created by emil.ivanov on 9/9/18.
 */
class NoteListViewModel(val repository: RepositoryNotes) : ViewModel() {
    fun getNotes(): LiveData<PagedList<NoteEntry>> {
        return repository.loadNotes().data
    }

    fun delete(noteEntry: NoteEntry) {
        repository.deleteNote(noteEntry)
    }

}
