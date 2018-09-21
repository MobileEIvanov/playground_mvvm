package com.playground.data

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import com.playground.data.database.NotesLocalDataSource
import com.playground.entities.NoteEntry
import com.playground.entities.ResponseNotesRepo

/**
 * Created by emil.ivanov on 9/18/18.
 */
class RepositoryNotes(private val localDataSource: NotesLocalDataSource) {


    fun insertNote(noteEntry: NoteEntry) {
        localDataSource.insertNoteEntry(noteEntry)
    }


    fun updateNote(noteEntry: NoteEntry) {
        localDataSource.updateNoteEntry(noteEntry)
    }


    fun deleteNote(noteEntry: NoteEntry) {
        localDataSource.delete(noteEntry)
    }

    fun loadNotes(): ResponseNotesRepo {
        // Get the data source factory from the local source;
        val dataSourceFactory = localDataSource.query()

        // Get the paged list
        val pagedList = LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
                .setBoundaryCallback(RepoBoundaryCallback(localDataSource))
                .build()


        return ResponseNotesRepo(pagedList)
    }


    fun loadNoteById(id: Int): LiveData<NoteEntry> {
        return localDataSource.loadNoteById(id)
    }


    companion object {
        private const val DATABASE_PAGE_SIZE = 3
    }
}