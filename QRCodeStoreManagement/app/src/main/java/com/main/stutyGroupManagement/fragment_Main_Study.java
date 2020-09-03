package com.main.stutyGroupManagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_Main_Study extends Fragment implements View.OnClickListener{

    View v;
    public fragment_Main_Study() {
    }

    public static fragment_Main_Study newInstance() {
        fragment_Main_Study fragment = new fragment_Main_Study();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v=inflater.inflate(R.layout.fragment_main_study, container, false);

        return v;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

        }
    }
}