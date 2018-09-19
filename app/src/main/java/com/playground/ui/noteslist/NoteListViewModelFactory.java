package com.playground.ui.noteslist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.playground.data.RepositoryNotes;

/**
 * Created by emil.ivanov on 9/20/18.
 */
public class NoteListViewModelFactory implements ViewModelProvider.Factory {

    RepositoryNotes repository;

    public NoteListViewModelFactory(RepositoryNotes repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NoteListViewModel(repository);
    }
}
