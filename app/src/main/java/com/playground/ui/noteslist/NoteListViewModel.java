package com.playground.ui.noteslist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

import com.playground.data.RepositoryNotes;
import com.playground.entities.NoteEntry;

/**
 * Created by emil.ivanov on 9/9/18.
 */
public class NoteListViewModel extends ViewModel {

    RepositoryNotes repository;

    public NoteListViewModel(RepositoryNotes repositoryNotes) {
        this.repository = repositoryNotes;
    }

    public LiveData<PagedList<NoteEntry>> getNotes() {
        return repository.loadNotes().getData();
    }

    public void delete(NoteEntry noteEntry) {
        repository.deleteNote(noteEntry);
    }

}
