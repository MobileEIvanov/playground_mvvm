package com.playground.data.database

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.*


/**
 * Created by emil.ivanov on 9/2/18.
 */
@Dao
interface NoteEntryDao {

    @Query("SELECT * FROM note ORDER BY priority")
    fun loadAllNotes(): DataSource.Factory<Int, NoteEntry>

    @Insert
    fun insertNote(noteEntry: NoteEntry)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(noteEntry: NoteEntry)

    @Delete
    fun deleteNote(noteEntry: NoteEntry)

    @Query("SELECT * FROM note WHERE (id LIKE :noteId)")
    fun loadNoteById(noteId: Int): LiveData<NoteEntry>

    @Query("SELECT * FROM note WHERE title LIKE :noteTitle")
    fun searchByTitle(noteTitle: String): NoteEntry
}
