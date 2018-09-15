package com.playground.ui.noteslist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.playground.AppExecutors;
import com.playground.database.AppDatabase;
import com.playground.database.NoteEntry;

import java.util.List;

/**
 * Created by emil.ivanov on 9/9/18.
 */
public class NoteListViewModel extends AndroidViewModel {

    private LiveData<List<NoteEntry>> notes;
    private AppDatabase appDatabase;

    public NoteListViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getInstance(application);
        notes = appDatabase.noteDao().loadAllNotes();
    }

    public LiveData<List<NoteEntry>> getNotes() {
        return notes;
    }

    public void delete(NoteEntry noteEntry) {
        AppExecutors.getInstance().diskIO().execute(() -> appDatabase.noteDao().deleteNote(noteEntry));
    }

}
