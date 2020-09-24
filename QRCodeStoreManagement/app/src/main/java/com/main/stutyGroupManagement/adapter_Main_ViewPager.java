package com.main.stutyGroupManagement;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class adapter_Main_ViewPager extends FragmentPagerAdapter {

    ArrayList<String> fragmentList=new ArrayList<>();
    public adapter_Main_ViewPager(FragmentManager fm) {
        super(fm);
    }

    public void addArrayList(String arrayListName){
        fragmentList.add(arrayListName);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragment_Main_Notice_Board.newInstance();
            case 1:
                return main_my_group.newInstance();
            case 2:
                return fragment_Main_Talk.newInstance();
            case 3:
                return fragment_Main_Study.newInstance();
            case 4:
                return fragment_Main_ETC.newInstance();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
