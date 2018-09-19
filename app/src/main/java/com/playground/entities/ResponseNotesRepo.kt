package com.playground.entities

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList

/**
 * Created by emil.ivanov on 9/19/18.
 */
data class ResponseNotesRepo(val data: LiveData<PagedList<NoteEntry>>)