package com.playground.ui.noteslist

import android.support.v7.util.DiffUtil
import com.playground.entities.NoteEntry
import java.util.List

/**
 * Created by emil.ivanov on 9/8/18.
 */
class DiffNotes(private val notesOld: List<NoteEntry>, private val newNotes: List<NoteEntry>) : DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return if (notesOld != null) notesOld.size else 0
    }

    @Override
    override fun getNewListSize(): Int {
        return if (newNotes != null) newNotes.size else 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return notesOld[oldItemPosition].title == newNotes[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return notesOld[oldItemPosition] == newNotes[newItemPosition]
    }

}