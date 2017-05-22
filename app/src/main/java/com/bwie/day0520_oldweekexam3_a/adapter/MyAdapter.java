package com.bwie.day0520_oldweekexam3_a.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwie.day0520_oldweekexam3_a.fragment.Fragment_fenlei;
import com.bwie.day0520_oldweekexam3_a.fragment.Fragment_quanzi;
import com.bwie.day0520_oldweekexam3_a.fragment.Fragment_shouye;
import com.bwie.day0520_oldweekexam3_a.fragment.Fragment_wode;

/**
 * Created by
 * Chenxin
 * on 2017/5/20.
 */

public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position){
            case 0:

                fragment = new Fragment_shouye();

                break;

            case 1:

                fragment = new Fragment_fenlei();

                break;

            case 2:

                fragment = new Fragment_quanzi();

                break;

            case 3:

                fragment = new Fragment_wode();

                break;
        }


        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
