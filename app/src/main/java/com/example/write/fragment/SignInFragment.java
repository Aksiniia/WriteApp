package com.example.write.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.write.R;
import com.example.write.activity.MainActivity;

public class SignInFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        Activity context = (Activity) getContext();

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
            context.startActivity(new Intent(getContext(), MainActivity.class));
            context.finish();
        });

        return view;
    }
}