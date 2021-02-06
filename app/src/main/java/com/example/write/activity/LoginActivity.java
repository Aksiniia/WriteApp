package com.example.write.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.write.R;
import com.example.write.fragment.SignInFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.loginContainer, new SignInFragment())
                .commit();
    }
}