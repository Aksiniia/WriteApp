package com.example.write.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.write.R;
import com.example.write.data.UserData;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        UserData.userNotes = new ArrayList<>();
        new Handler().postDelayed(() -> {
            startActivity(
                    new Intent(
                            SplashActivity.this,
                            LoginActivity.class
                    )
            );
            finish();
        }, 2000);
    }
}