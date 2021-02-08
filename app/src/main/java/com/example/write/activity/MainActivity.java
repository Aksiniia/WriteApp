package com.example.write.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.write.R;
import com.example.write.adapter.MainAdapter;
import com.example.write.data.UserData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserData.userNotes = new ArrayList<>();

        RecyclerView mainRecycler = findViewById(R.id.mainRecycler);
        mainRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        mainRecycler.setAdapter(new MainAdapter(this, UserData.userNotes));

        UserData.mainRecycler = mainRecycler;
    }
}