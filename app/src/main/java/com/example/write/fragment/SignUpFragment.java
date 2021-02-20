package com.example.write.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.write.R;
import com.example.write.activity.MainActivity;

public class SignUpFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        Activity context = (Activity) getContext();

        EditText signUpName = view.findViewById(R.id.signUpName);
        EditText signUpEmail = view.findViewById(R.id.signUpEmail);
        EditText signUpPassword = view.findViewById(R.id.signUpPassword);

        view.findViewById(R.id.signUpToSignIn).setOnClickListener(v ->
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.loginContainer, new SignInFragment())
                        .commit());

        view.findViewById(R.id.signUpConfirm).setOnClickListener(v -> {
            String name = signUpName.getText().toString();
            String email = signUpEmail.getText().toString();
            String password = signUpPassword.getText().toString();

            if (name.isEmpty())
                Toast.makeText(context, "Введите имя пользователя", Toast.LENGTH_SHORT).show();

            else if (!email.contains("@"))
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