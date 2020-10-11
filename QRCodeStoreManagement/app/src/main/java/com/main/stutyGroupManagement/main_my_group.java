package com.main.stutyGroupManagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link main_my_group#newInstance} factory method to
 * create an instance of this fragment.
 */
public class main_my_group extends Fragment implements View.OnClickListener{
    View v;
    public main_my_group() {
        // Required empty public constructor
    }

    public static main_my_group newInstance() {
        main_my_group fragment = new main_my_group();
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

        v=inflater.inflate(R.layout.fragment_main_my_group, container, false);

        return v;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

        }
    }
}