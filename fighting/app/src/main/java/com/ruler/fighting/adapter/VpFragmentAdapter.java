package com.ruler.fighting.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * name:SailCheung
 * date:2019-06-12
 * time:下午 08:46
 * year:2019
 * project_name:fighting
 */
public class VpFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentArrayList;

    public VpFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.fragmentArrayList = fragmentArrayList;
    }

    public VpFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentArrayList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
}
