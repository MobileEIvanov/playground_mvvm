package com.playground.ui.noteslist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.playground.database.AppDatabase;
import com.playground.database.NoteEntry;

import java.util.List;

/**
 * Created by emil.ivanov on 9/9/18.
 */
public class NoteListViewModel extends AndroidViewModel {

    private LiveData<List<NoteEntry>> notes;

    public NoteListViewModel(@NonNull Application application) {
        super(application);
        notes = AppDatabase.getInstance(application).noteDao().loadAllNotes();
    }

    public LiveData<List<NoteEntry>> getNotes() {
        return notes;
    }
}
