package com.example.write.activity;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.write.R;
import com.example.write.data.UserData;
import com.example.write.model.NoteModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        int notePosition =
                getIntent().getIntExtra(
                        "noteIndex",
                        -1
                );

        EditText editField = findViewById(R.id.editField);
        editField.setText(getIntent().getStringExtra("noteText"));

        findViewById(R.id.editSave).setOnClickListener(v -> {
            String text = editField.getText().toString();

            if (!text.equals("")) {
                if (notePosition == 0)
                    UserData.userNotes.add(
                        new NoteModel(
                                DateTimeFormatter
                                        .ofPattern("dd.MM.yyyy HH:mm")
                                        .format(LocalDateTime.now()),
                                text
                        )
                );

                else
                    UserData.userNotes.get(notePosition - 1).text = text;

            } else if (notePosition != 0)
                UserData.userNotes.remove(notePosition - 1);

            UserData.mainRecycler.getAdapter().notifyDataSetChanged();
            finish();
        });
    }
}