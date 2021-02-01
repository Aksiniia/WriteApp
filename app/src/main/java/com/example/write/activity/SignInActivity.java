package com.example.write.activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.write.R;
import com.example.write.SignIn;

public class SignInActivity extends AppCompatActivity {

    Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportFragmentManager()
                .beginTransaction()
                    .add(R.id.container, new SignIn())
                    .commit();

        //findViewById(R.id.signInSwipe).setOnClickListener(v -> startActivity(new Intent(SignInActivity.this, SignUpActivity.class)));

        signIn = findViewById(R.id.button_in);
        signIn.setOnClickListener(v -> {
                    signIn.setTextColor(getColor(R.color.colorWhite));
                    signUp.setTextColor(getColor(R.color.colorGray));
                    getSupportFragmentManager()
                            .beginTransaction()
                                .replace(R.id.container, new SignIn())
                                .commit();
                }
        );


        signUp = findViewById(R.id.button_up);
        signUp.setOnClickListener(v -> {
                    signIn.setTextColor(getColor(R.color.colorGray));
                    signUp.setTextColor(getColor(R.color.colorWhite));
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new SignUpFragment()).commit();
                }
        );
    }
}