package com.example.write.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.write.R;
import com.example.write.activity.MainActivity;

public class SignUpFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        Activity context = (Activity) getContext();

        view.findViewById(R.id.signUpToSignIn).setOnClickListener(v ->
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.loginContainer, new SignInFragment())
                        .commit());

        view.findViewById(R.id.signUpConfirm).setOnClickListener(v -> {
            context.startActivity(new Intent(getContext(), MainActivity.class));
            context.finish();
        });
        return view;
    }
}