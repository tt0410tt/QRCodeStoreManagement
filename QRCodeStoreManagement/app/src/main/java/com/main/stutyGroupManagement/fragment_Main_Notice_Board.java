package com.main.stutyGroupManagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class fragment_Main_Notice_Board extends Fragment implements View.OnClickListener{

    View v;
    public fragment_Main_Notice_Board() {
        // Required empty public constructor
    }

    public static fragment_Main_Notice_Board newInstance() {
        fragment_Main_Notice_Board fragment = new fragment_Main_Notice_Board();
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

        v=inflater.inflate(R.layout.fragment__notice__board, container, false);

        return v;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

        }
    }
}