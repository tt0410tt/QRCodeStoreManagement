package com.main.stutyGroupManagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Main_screen extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_yellow_circle,
            R.drawable.selector_study_board,
            R.drawable.selector_study_board
    };
    Drawable ic_yellow_circle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ic_yellow_circle =getResources().getDrawable(R.drawable.ic_yellow_circle);
        viewPager = (ViewPager) findViewById(R.id.main_view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {

        View view1 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img1 = view1.findViewById(R.id.img_tab);
        TextView txt1 = view1.findViewById(R.id.tab);
        img1.setImageResource(R.drawable.ic_baseline_people_alt_24);
        txt1.setText("스터디 게시판");
        /*tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_yellow_circle,0, 0);*/

        View view2 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img2 = view2.findViewById(R.id.img_tab);
        TextView txt2 = view2.findViewById(R.id.tab);
        img2.setImageResource(R.drawable.ic_baseline_people_alt_24);
        txt2.setText("마이 그룹");
        /*tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_yellow_circle,0, 0);*/

        View view3 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img3 = view3.findViewById(R.id.img_tab);
        TextView txt3= view3.findViewById(R.id.tab);
        img3.setImageResource(R.drawable.ic_baseline_people_alt_24);
        txt3.setText("채팅");
        /*tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_yellow_circle,0, 0);*/

        View view4 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img4 = view4.findViewById(R.id.img_tab);
        TextView txt4 = view4.findViewById(R.id.tab);
        img4.setImageResource(R.drawable.ic_baseline_people_alt_24);
        txt4.setText("마이 스터디");
        /*tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_yellow_circle,0, 0);*/


        View view5 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img5 = view5.findViewById(R.id.img_tab);
        TextView txt5 = view5.findViewById(R.id.tab);
        img5.setImageResource(R.drawable.ic_baseline_people_alt_24);
        txt5.setText("더보기");
        /*tab1.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_yellow_circle,0, 0);*/
        tabLayout.getTabAt(0).setCustomView(view1);
        tabLayout.getTabAt(1).setCustomView(view2);
        tabLayout.getTabAt(2).setCustomView(view3);
        tabLayout.getTabAt(3).setCustomView(view4);
        tabLayout.getTabAt(4).setCustomView(view5);

       /* TextView tab2 = (TextView) LayoutInflater.from(this).inflate(R.layout.activity_custom_tab, null);
        tab2.setText("마이 그룹");
        ImageView img2 = (ImageView) LayoutInflater.from(this).inflate(R.layout.activity_custom_tab, null);
        img2.setImageResource(R.drawable.ic_baseline_people_alt_24);
        *//*tab2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_baseline_people_alt_24, 0, 0);*//*
        tabLayout.getTabAt(1).setCustomView(tab2);

        TextView tab3 = (TextView) LayoutInflater.from(this).inflate(R.layout.activity_custom_tab, null);
        tab3.setText("채팅");
        ImageView img3 = (ImageView) LayoutInflater.from(this).inflate(R.layout.activity_custom_tab, null);
        img3.setImageResource(R.drawable.ic_baseline_people_alt_24);
       *//* tab3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_android_black_24dp, 0, 0);*//*
        tabLayout.getTabAt(2).setCustomView(tab3);

        ImageView img4 = (ImageView) LayoutInflater.from(this).inflate(R.layout.activity_custom_tab, null);
        img4.setImageResource(R.drawable.ic_baseline_people_alt_24);
        TextView tab4 = (TextView) LayoutInflater.from(this).inflate(R.layout.activity_custom_tab, null);
        tab4.setText("마이 스터디");
       *//* tab4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_android_black_24dp, 0, 0);*//*
        tabLayout.getTabAt(3).setCustomView(tab4);

        ImageView img5 = (ImageView) LayoutInflater.from(this).inflate(R.layout.activity_custom_tab, null);
        img5.setImageResource(R.drawable.ic_baseline_people_alt_24);
        TextView tab5 = (TextView) LayoutInflater.from(this).inflate(R.layout.activity_custom_tab, null);
        tab5.setText("더보기");
       *//* tab5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_android_black_24dp, 0, 0);*//*
        tabLayout.getTabAt(4).setCustomView(tab5);*/
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter_Main_ViewPager adapter = new adapter_Main_ViewPager(getSupportFragmentManager());
        adapter.addFragment(new fragment_Main_Notice_Board(), "스터디 게시판");
        adapter.addFragment(new main_my_group(), "마이 그룹");
        adapter.addFragment(new fragment_Main_Talk(), "채팅");
        adapter.addFragment(new fragment_Main_Study(), "마이 스터디");
        adapter.addFragment(new fragment_Main_ETC(), "더보기");
        viewPager.setAdapter(adapter);
    }

   /* class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }*/
        /*main_ViewPager=findViewById(R.id.main_view_pager);
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
        setupTabIcons();
    }

    private void addTab(String tabName){
*//*        main_TabLayout.addTab(main_TabLayout.newTab().setText(tabName));*//*
        fragmentPagerAdapter.addArrayList(tabName);
        main_TabLayout.addTab(main_TabLayout.newTab().setIcon(R.drawable.ic_yellow_circle));
    }

    private void setupTabIcons() {

        View view0 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img0 = view0.findViewById(R.id.img_tab);
        TextView txt0 = view0.findViewById(R.id.txt_tab);

        View view1 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img1 = view1.findViewById(R.id.img_tab);
        TextView txt1 = view1.findViewById(R.id.txt_tab);

        View view2 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img2 = view2.findViewById(R.id.img_tab);
        TextView txt2 = view2.findViewById(R.id.txt_tab);

        View view3 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img3 = view3.findViewById(R.id.img_tab);
        TextView txt3 = view3.findViewById(R.id.txt_tab);

        View view4 = getLayoutInflater().inflate(R.layout.activity_custom_tab, null);
        ImageView img4 = view4.findViewById(R.id.img_tab);
        TextView txt4 = view4.findViewById(R.id.txt_tab);

        img0.setImageResource(R.drawable.selector_study_board);
        txt0.setText("스터디 게시판");

        img1.setImageResource(R.drawable.elipse_orange);
        txt1.setText("마이그룹");

        img2.setImageResource(R.drawable.elipse_orange);
        txt2.setText("채팅");

        img3.setImageResource(R.drawable.elipse_orange);
        txt3.setText("마이 스터디");

        img4.setImageResource(R.drawable.elipse_orange);
        txt4.setText("더보기");

        main_TabLayout.getTabAt(0).setCustomView(view0);
        main_TabLayout.getTabAt(1).setCustomView(view1);
        main_TabLayout.getTabAt(2).setCustomView(view2);
        main_TabLayout.getTabAt(3).setCustomView(view3);
        main_TabLayout.getTabAt(4).setCustomView(view4);

    }*/

}