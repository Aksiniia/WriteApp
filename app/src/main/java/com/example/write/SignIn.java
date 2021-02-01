package com.example.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.write.activity.UserActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignIn extends Fragment {

    public SignIn() {
        // Required empty public constructor
    }

    public static SignIn newInstance() {
        return new SignIn();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        view.findViewById(R.id.b_in).setOnClickListener(v -> {
            try {
                // TODO: check login and password

                requireActivity().startActivity(new Intent(getContext(), UserActivity.class));
                requireActivity().finish();

            } catch (Exception e) {

            }
        });

        return view;
    }
}