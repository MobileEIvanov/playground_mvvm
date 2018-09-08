package com.playground.ui.noteslist;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.playground.database.NoteEntry;

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
        return this.notesOld.size();
    }

    @Override
    public int getNewListSize() {
        return this.notesNew.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return notesOld.get(oldItemPosition).getId() == notesNew.get(newItemPosition).getId();
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
