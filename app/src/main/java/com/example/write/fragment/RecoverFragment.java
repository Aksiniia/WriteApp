package com.example.write.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.write.R;

public class RecoverFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recover, container, false);

        view.findViewById(R.id.recoverToSignIn).setOnClickListener(v ->
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.loginContainer, new SignInFragment())
                        .commit());

        view.findViewById(R.id.recoverToSignUp).setOnClickListener(v ->
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.loginContainer, new SignUpFragment())
                        .commit());

        return view;


    }
}