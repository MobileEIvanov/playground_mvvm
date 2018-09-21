package com.playground.ui.noteslist;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.playground.data.database.NoteEntry;

import java.util.List;

/**
 * Created by emil.ivanov on 9/8/18.
 */
public class DiffNotes extends DiffUtil.Callback {

    private List<NoteEntry> notesOld;
    private List<NoteEntry> notesNew;

    public DiffNotes(List<NoteEntry> notesOld, List<NoteEntry> notesNew) {
        this.notesOld = notesOld;
        this.notesNew = notesNew;
    }

    @Override
    public int getOldListSize() {
        return notesOld != null ? notesOld.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return notesNew != null ? notesNew.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return notesOld.get(oldItemPosition).getTitle().equalsIgnoreCase(notesNew.get(newItemPosition).getTitle());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return notesOld.get(oldItemPosition).equals(notesNew.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }


}
