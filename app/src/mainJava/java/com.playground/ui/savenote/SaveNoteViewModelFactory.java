package com.playground.ui.savenote;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.playground.data.RepositoryNotes;

/**
 * Created by emil.ivanov on 9/9/18.
 */
public class SaveNoteViewModelFactory implements ViewModelProvider.Factory {

    private RepositoryNotes repository;


    public SaveNoteViewModelFactory(RepositoryNotes repositoryNotes) {
        this.repository = repositoryNotes;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SaveNoteViewModel(repository);
    }
}
