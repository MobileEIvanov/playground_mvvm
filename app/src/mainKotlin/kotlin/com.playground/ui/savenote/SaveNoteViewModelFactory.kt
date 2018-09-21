package com.playground.ui.savenote

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.playground.data.RepositoryNotes

/**
 * Created by emil.ivanov on 9/9/18.
 */
class SaveNoteViewModelFactory(val repository: RepositoryNotes) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SaveNoteViewModel::class.java)) {
            return SaveNoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
