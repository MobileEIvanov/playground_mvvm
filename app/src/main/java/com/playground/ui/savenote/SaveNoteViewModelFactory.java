package com.playground.ui.savenote;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.playground.database.AppDatabase;

/**
 * Created by emil.ivanov on 9/9/18.
 */
public class SaveNoteViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private AppDatabase database;
    private int id;

    public SaveNoteViewModelFactory(AppDatabase database, int id) {
        this.database = database;
        this.id = id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SaveNoteViewModel(database, id);
    }
}
