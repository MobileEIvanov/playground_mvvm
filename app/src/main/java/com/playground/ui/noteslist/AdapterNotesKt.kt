package com.playground.ui.noteslist

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.playground.R
import com.playground.entities.NoteEntry
import com.playground.utils.inflate
import kotlinx.android.synthetic.main.item_list_notes.view.*

/**
 * Created by emil.ivanov on 9/8/18.
 *
 * Implementation for click listener reference:
 * https://www.andreasjakl.com/recyclerview-kotlin-style-click-listener-android/
 */
class AdapterNotesKt
constructor(private val clickListener: (NoteEntry) -> Unit,
            private val deleteNoteListener: (NoteEntry) -> Unit)
    : PagedListAdapter<NoteEntry, AdapterNotesKt.VHNotes>(NOTE_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHNotes {
        val inflatedView = parent.inflate(R.layout.item_list_notes, false)
        return VHNotes(inflatedView)
    }

    override fun onBindViewHolder(holder: VHNotes, position: Int) {
        val noteItem = getItem(position)
        holder.bindData(noteItem, clickListener, deleteNoteListener)
        holder.itemView.tag = noteItem
    }


    class VHNotes(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private var view: View = itemView
        private var note: NoteEntry? = null


        fun bindData(note: NoteEntry?, clickListener: (NoteEntry) -> Unit, deleteNoteListener: (NoteEntry) -> Unit) {
            if (note != null) {
                this.note = note
                view.tvNoteTitle.text = note.title
                view.tvNoteDescription.text = note.description
                view.btnDelete.setOnClickListener { deleteNoteListener(note) }
                view.setOnClickListener { clickListener(note) }
            }
        }
    }


    companion object {
        private val NOTE_COMPARATOR = object : DiffUtil.ItemCallback<NoteEntry>() {
            override fun areItemsTheSame(oldItem: NoteEntry, newItem: NoteEntry): Boolean =
                    oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: NoteEntry, newItem: NoteEntry): Boolean =
                    oldItem == newItem
        }
    }


}