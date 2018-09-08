package com.playground.ui.noteslist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.playground.R
import com.playground.database.NoteEntry
import kotlinx.android.synthetic.main.item_list_notes.view.*

/**
 * Created by emil.ivanov on 9/8/18.
 */
class AdapterNotesKt(private val notes: ArrayList<NoteEntry>) : RecyclerView.Adapter<AdapterNotesKt.VHNotes>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHNotes {
        val inflatedView = parent.inflate(R.layout.item_list_notes, false)
        return VHNotes(inflatedView)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: VHNotes, position: Int) {
        holder.bindData(this.notes[position])
        holder.itemView.tag = notes[position]
    }


    class VHNotes(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var view: View = itemView
        private var note: NoteEntry? = null

        fun bindData(note: NoteEntry) {
            this.note = note
            view.tvNoteTitle.text = note.title
        }
    }

}