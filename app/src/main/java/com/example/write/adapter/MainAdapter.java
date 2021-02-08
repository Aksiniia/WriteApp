package com.example.write.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.write.R;
import com.example.write.activity.EditActivity;
import com.example.write.model.NoteModel;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Locale;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<NoteModel> notes;

    public MainAdapter(Context context, List<NoteModel> notes) {
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
                                viewType == 0 ? R.layout.add_note : R.layout.note_card,
                                parent,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position != 0) {
            NoteModel note = notes.get(position - 1);

            ((TextView) holder.itemView.findViewById(R.id.noteDate)).setText(note.date);
            ((TextView) holder.itemView.findViewById(R.id.noteText)).setText(note.text);

            ((TextView) holder.itemView.findViewById(R.id.notePages)).setText(
                    String.format(
                            Locale.getDefault(),
                            "%d Pages",
                            StringUtils.countMatches(note.text, "\n\n") + 1
                    )
            );
        }

        holder.itemView.setOnClickListener(v ->
                context.startActivity(
                        new Intent(
                                context,
                                EditActivity.class
                        ).putExtra(
                                "noteText",
                                position == 0 ? "" : notes.get(position - 1).text
                        ).putExtra(
                                "noteIndex",
                                position
                        )
                )
        );
    }

    @Override
    public int getItemCount() {
        return notes.size() + 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
