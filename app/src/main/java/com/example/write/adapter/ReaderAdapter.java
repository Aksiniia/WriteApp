package com.example.write.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.write.R;
import com.example.write.model.NoteModel;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Locale;

public class ReaderAdapter extends RecyclerView.Adapter<ReaderAdapter.ViewHolder> {

    Context context;
    List<NoteModel> notes;

    public ReaderAdapter(Context context, List<NoteModel> notes) {
        this.context = context;
        this.notes = notes;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(context)
                        .inflate(
                                R.layout.note_card,
                                parent,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoteModel note = notes.get(position);

        ((TextView) holder.itemView.findViewById(R.id.noteDate)).setText(note.date);
        ((TextView) holder.itemView.findViewById(R.id.noteText)).setText(note.text);

        ((TextView) holder.itemView.findViewById(R.id.notePages)).setText(
                String.format(
                        Locale.getDefault(),
                        "%d Pages",
                        StringUtils.countMatches(note.text, "\n\n")
                )
        );


        holder.itemView.setOnClickListener(v ->
                context.startActivity(
                        new Intent(
                                context,
                                EditActivity.class
                        ).putExtra(
                                "noteText",
                                notes.get(position).text
                        ).putExtra(
                                "noteIndex",
                                position
                        )
                )
        );
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
