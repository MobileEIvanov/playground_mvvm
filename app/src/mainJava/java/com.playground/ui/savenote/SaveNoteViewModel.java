package com.playground.ui.savenote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.playground.data.RepositoryNotes;
import com.playground.data.database.NoteEntry;

import org.jetbrains.annotations.NotNull;

/**
 * Created by emil.ivanov on 9/9/18.
 */
class SaveNoteViewModel extends ViewModel {

    private LiveData<NoteEntry> noteEntry;
    private RepositoryNotes repository;

    public SaveNoteViewModel(RepositoryNotes repository) {
        this.repository = repository;
    }

    public LiveData<NoteEntry> getNoteEntry(int id) {
        if (this.noteEntry == null) {
            this.noteEntry = repository.loadNoteById(id);
        }
        return this.noteEntry;
    }

    public void insert(NoteEntry noteEntry) {
        repository.insertNote(noteEntry);
    }

    public void update(@NotNull NoteEntry noteEntry) {
        repository.updateNote(noteEntry);
    }
}
