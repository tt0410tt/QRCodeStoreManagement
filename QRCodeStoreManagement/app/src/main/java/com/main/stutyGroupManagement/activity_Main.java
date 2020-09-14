package com.main.stutyGroupManagement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class activity_Main extends AppCompatActivity {

    ViewPager main_ViewPager;
    TabLayout main_TabLayout;
    private adapter_Main_ViewPager fragmentPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main);
        main_ViewPager=findViewById(R.id.main_view_pager);
        main_TabLayout=findViewById(R.id.main_tab);

        fragmentPagerAdapter = new adapter_Main_ViewPager(getSupportFragmentManager());
        addTab("게시판");
        addTab("공부");
        addTab("카톡");
        addTab("개인");
        addTab("더보기");

        main_ViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(main_TabLayout));
        main_TabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                main_ViewPager.setCurrentItem(tab.getPosition());
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

    private void addTab(String tabName){
        main_TabLayout.addTab(main_TabLayout.newTab().setText(tabName));
        fragmentPagerAdapter.addArrayList(tabName);
    }
}

