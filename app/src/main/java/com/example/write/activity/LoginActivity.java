package com.example.write.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.write.R;
import com.example.write.fragment.SignInFragment;
import com.example.write.fragment.SignUpFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        changeFragment(new SignInFragment());

        TextView loginSignIn = findViewById(R.id.loginSignIn);
        TextView loginSignUp = findViewById(R.id.loginSignUp);

        loginSignIn.setOnClickListener(v -> {
                    loginSignIn.setTextColor(getColor(R.color.colorWhite));
                    loginSignUp.setTextColor(getColor(R.color.colorGray));

                    changeFragment(new SignInFragment());
                }
        );

        loginSignUp.setOnClickListener(v -> {
                    loginSignIn.setTextColor(getColor(R.color.colorGray));
                    loginSignUp.setTextColor(getColor(R.color.colorWhite));

                    changeFragment(new SignUpFragment());
                }
        );
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.loginContainer, fragment)
                .commit();
    }
}