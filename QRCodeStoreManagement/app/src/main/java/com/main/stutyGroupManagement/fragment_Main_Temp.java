package com.main.stutyGroupManagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.main.stutyGroupManagement.R;

public class fragment_Main_Temp extends Fragment implements View.OnClickListener{

    View v;
    public fragment_Main_Temp() {
        // Required empty public constructor
    }

    public static fragment_Main_Temp newInstance() {
        fragment_Main_Temp fragment = new fragment_Main_Temp();
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

        v=inflater.inflate(R.layout.fragment_main_temp, container, false);

        return v;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

        }
    }
}