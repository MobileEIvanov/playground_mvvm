package com.playground.ui.noteslist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.playground.data.RepositoryNotes

/**
 * Created by emil.ivanov on 9/20/18.
 */
class NoteListViewModelFactory(val repository: RepositoryNotes) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteListViewModel::class.java)) {
            return NoteListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
