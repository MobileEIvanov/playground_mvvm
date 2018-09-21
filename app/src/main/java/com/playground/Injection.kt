/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.playground

import android.arch.lifecycle.ViewModelProvider
import android.content.Context

import com.playground.data.RepositoryNotes
import com.playground.data.database.AppDatabase
import com.playground.data.database.NotesLocalDataSource
import com.playground.ui.noteslist.NoteListViewModelFactory
import com.playground.ui.savenote.SaveNoteViewModelFactory
import java.util.concurrent.Executors

/**
 * Credits: Codelab Google Paging Library
 * Class that handles object creation.
 * Like this, objects can be passed as parameters in the constructors and then replaced for
 * testing, where needed.
 */
object Injection {

    /**
     * Creates an instance of [NotesLocalDataSource] based on the database DAO.
     */
    private fun provideLocalNotesDatasource(context: Context): NotesLocalDataSource {
        val database = AppDatabase.getInstance(context)
        return NotesLocalDataSource(database.noteDao(), Executors.newSingleThreadExecutor())
    }

    /**
     * Creates an instance of [RepositoryNotes] based on the [Network Service if Implemented] and a
     * [NotesLocalDataSource]
     */
    private fun provideRepositoryNotes(context: Context): RepositoryNotes {
        return RepositoryNotes(provideLocalNotesDatasource(context))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideNotesListViewModelFactory(context: Context): ViewModelProvider.Factory {
        return NoteListViewModelFactory(provideRepositoryNotes(context))
    }

    fun provideSaveNoteViewModelFactory(context: Context): ViewModelProvider.Factory {
        return SaveNoteViewModelFactory(provideRepositoryNotes(context))
    }
}