package com.playground.ui.noteslist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.playground.R;
import com.playground.database.NoteEntry;
import com.playground.databinding.ItemListNotesBinding;

import java.util.List;

/**
 * Created by emil.ivanov on 9/8/18.
 */
public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.VHNotes> {

    private List<NoteEntry> mData;
    private Context mContext;

    public AdapterNotes(Context context, List<NoteEntry> listNotes) {
        mData = listNotes;
        mContext = context;
    }

    @NonNull
    @Override
    public VHNotes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_notes, parent, false);
        return new VHNotes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHNotes holder, int position) {
        holder.bindData(mData.get(position));
        holder.itemView.setTag(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateList(List<NoteEntry> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffNotes(mData, newList));
        diffResult.dispatchUpdatesTo(this);
    }

    class VHNotes extends RecyclerView.ViewHolder {
        private ItemListNotesBinding mBinding;

        VHNotes(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        void bindData(NoteEntry noteEntry) {
            if (!TextUtils.isEmpty(noteEntry.getTitle())) {
                mBinding.tvNoteTitle.setText(noteEntry.getTitle());
            }
        }
    }
}
