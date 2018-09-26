package com.adi.aditya.graphviews;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Communicator {

    TabLayout tblt=null;
    TabItem data=null;
    TabItem pie=null;
    TabItem bar=null;
    TabItem line=null;
    ViewPager viewPager=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tblt=(TabLayout)findViewById(R.id.tblyt);
        data=(TabItem)findViewById(R.id.data);
        pie=(TabItem)findViewById(R.id.PieChart);
        bar=(TabItem)findViewById(R.id.BarGraph);
        line=(TabItem)findViewById(R.id.LineGraph);
        viewPager=(ViewPager)findViewById(R.id.viewPager);

        PageAdapter adapter=new PageAdapter(getSupportFragmentManager(),tblt.getTabCount());
        viewPager.setAdapter(adapter);

        tblt.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(),true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tblt));
    }

    @Override
    public void Respond(ArrayList<POJO> lst) {
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
      // PieFragment pf= (PieFragment) fragmentManager.findFragmentById(R.id.PieChart);
        //pf.Transfer(lst);
       PieFragment pieFragment1=new PieFragment();
       pieFragment1.Transfer(lst);
    }

    @Override
    public void Respondb(ArrayList<POJO> lst) {
        BarFragment barFragment=new BarFragment();
        barFragment.Transfer(lst);
    }

    @Override
    public void Respondl(ArrayList<POJO> lst) {
        LineFragment lineFragment=new LineFragment();
        lineFragment.Transfer(lst);
    }
}
