package com.playground.data

import android.arch.paging.PagedList
import android.util.Log
import com.playground.data.database.NotesLocalDataSource
import com.playground.entities.NoteEntry

/**
 * Created by emil.ivanov on 9/19/18.
 * Reference https://codelabs.developers.google.com/codelabs/android-paging/index.html?index=..%2F..%2Findex#8
 * Callback responsible to notify when the local data source has run out of items.
 * On such occasion if there is a remote repository we load the items from network and insert them in DB
 *
 */
class RepoBoundaryCallback(localDataSource: NotesLocalDataSource) : PagedList.BoundaryCallback<NoteEntry>() {

    override fun onZeroItemsLoaded() {
        Log.d("Boundary", "onZeroItemsLoaded")
    }

    override fun onItemAtEndLoaded(itemAtEnd: NoteEntry) {
        Log.d("Boundary", "onItemAtEndLoaded:" + itemAtEnd.title)
    }

}