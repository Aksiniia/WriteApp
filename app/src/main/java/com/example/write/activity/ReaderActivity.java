package com.example.write.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.write.R;

public class ReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        ((TextView) findViewById(R.id.readerText)).setText(
                getIntent().getStringExtra("noteText")
        );

        findViewById(R.id.readerBack).setOnClickListener(v -> finish());
    }
}
