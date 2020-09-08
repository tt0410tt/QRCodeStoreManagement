package com.main.stutyGroupManagement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class activity_Main extends AppCompatActivity {

    ViewPager main_ViewPager;
    TabLayout main_TabLayout;
    private FragmentPagerAdapter fragmentPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main);
        main_ViewPager=findViewById(R.id.main_view_pager);
        main_TabLayout=findViewById(R.id.main_tab);

        main_TabLayout.addTab(main_TabLayout.newTab().setText("게시판"));
        main_TabLayout.addTab(main_TabLayout.newTab().setText("공부"));
        main_TabLayout.addTab(main_TabLayout.newTab().setText("카톡"));
        main_TabLayout.addTab(main_TabLayout.newTab().setText("더보기"));
        fragmentPagerAdapter = new adapter_Main_ViewPager(getSupportFragmentManager());

        main_ViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(main_TabLayout));
        main_TabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                main_ViewPager.setCurrentItem( tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        main_ViewPager.setAdapter(fragmentPagerAdapter);
    }
}

