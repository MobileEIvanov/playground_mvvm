package com.playground.data.database

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import com.playground.entities.NoteEntry
import java.util.concurrent.Executor

/**
 * Local data source class responsible for making local database request.
 * The class uses Executor for performing work outside the main thread
 */
class NotesLocalDataSource(
        private val noteEntryDao: NoteEntryDao,
        private val ioExecutor: Executor) {


    fun insertNoteEntry(noteEntry: NoteEntry) {
        ioExecutor.execute {
            noteEntryDao.insertNote(noteEntry)
        }
    }

    fun updateNoteEntry(noteEntry: NoteEntry) {
        ioExecutor.execute {
            noteEntryDao.updateNote(noteEntry)
        }
    }


    fun delete(noteEntry: NoteEntry) {
        ioExecutor.execute {
            noteEntryDao.deleteNote(noteEntry)
        }
    }

    fun loadNoteById(id: Long): LiveData<NoteEntry> {
        return noteEntryDao.loadNoteById(id)
    }

    fun query(): DataSource.Factory<Int, NoteEntry> {
        return noteEntryDao.loadAllNotes()
    }

}