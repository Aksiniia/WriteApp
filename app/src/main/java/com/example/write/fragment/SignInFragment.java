package com.example.write.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.write.R;
import com.example.write.activity.MainActivity;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class SignInFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        Activity context = (Activity) getContext();

        EditText signInEmail = view.findViewById(R.id.signInEmail);
        EditText signInPassword = view.findViewById(R.id.signInPassword);

        view.findViewById(R.id.signInToSignUp).setOnClickListener(v ->
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.loginContainer, new SignUpFragment())
                        .commit());

        view.findViewById(R.id.signInRecover).setOnClickListener(v ->
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.loginContainer, new RecoverFragment())
                        .commit());

        view.findViewById(R.id.signInConfirm).setOnClickListener(v -> {
            String email = signInEmail.getText().toString();
            String password = signInPassword.getText().toString();

            if (!email.contains("@"))
                Toast.makeText(context, "Введите корректный Email", Toast.LENGTH_SHORT).show();

            else if (password.length() < 6)
                Toast.makeText(context, "Введите более длинный пароль", Toast.LENGTH_SHORT).show();

            else {
                context.startActivity(new Intent(getContext(), MainActivity.class));
                context.finish();
            }
        });

        return view;
    }
}