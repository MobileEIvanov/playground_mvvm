package com.playground.ui.savenote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.playground.AppExecutors;
import com.playground.database.AppDatabase;
import com.playground.database.NoteEntry;

import org.jetbrains.annotations.NotNull;

/**
 * Created by emil.ivanov on 9/9/18.
 */
class SaveNoteViewModel extends ViewModel {

    private LiveData<NoteEntry> noteEntry;
    private AppDatabase appDatabase;

    public SaveNoteViewModel(AppDatabase database, int id) {
        noteEntry = database.noteDao().loadNoteById(id);
        appDatabase = database;
    }

    public LiveData<NoteEntry> getNoteEntry() {
        return noteEntry;
    }

    public void insert(NoteEntry noteEntry) {
        AppExecutors.getInstance().diskIO().execute(() -> appDatabase.noteDao().insertNote(noteEntry));
    }

    public void update(@NotNull NoteEntry noteEntry) {
        AppExecutors.getInstance().diskIO().execute(() -> appDatabase.noteDao().updateNote(noteEntry));
    }
}
