package com.example.write.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.write.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
    public void SignUpActivity (android.view.View v) {
        startActivity(
                new Intent(
                        SignInActivity.this,
                SignUpActivity.class
                )
        );
    }
}