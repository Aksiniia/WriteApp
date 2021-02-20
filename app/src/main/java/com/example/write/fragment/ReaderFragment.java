package com.example.write.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.write.R;
import com.example.write.adapter.ReaderAdapter;
import com.example.write.data.UserData;


public class ReaderFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reader, container, false);

        Activity activity = ((Activity) container.getContext());

        RecyclerView readerRecycler = view.findViewById(R.id.readerRecycler);
        readerRecycler.setLayoutManager(new GridLayoutManager(activity, 2));
        readerRecycler.setAdapter(new ReaderAdapter(activity, UserData.userNotes));

        UserData.mainRecycler = readerRecycler;

        return view;
    }
}