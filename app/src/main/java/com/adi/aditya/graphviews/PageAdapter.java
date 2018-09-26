package com.adi.aditya.graphviews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    int numberOfPages;

    public PageAdapter(FragmentManager fm,int numberOfPages) {
        super(fm);
        this.numberOfPages=numberOfPages;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DataFragment();
            case 1:
                return new PieFragment();
            case 2:
                return new BarFragment();
            case 3:
                return new LineFragment();
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return numberOfPages;
    }
}
