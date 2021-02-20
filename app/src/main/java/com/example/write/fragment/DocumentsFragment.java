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
import com.example.write.adapter.MainAdapter;
import com.example.write.data.UserData;

public class DocumentsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_documents, container, false);

        Activity activity = ((Activity) container.getContext());

        RecyclerView documentsRecycler = view.findViewById(R.id.documentsRecycler);
        documentsRecycler.setLayoutManager(new GridLayoutManager(activity, 2));
        documentsRecycler.setAdapter(new MainAdapter(activity, UserData.userNotes));

        UserData.mainRecycler = documentsRecycler;

        return view;
    }
}
