package com.adi.aditya.graphviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    ArrayList<POJO> lst=new ArrayList<POJO>();

    public CustomAdapter(@NonNull FragmentActivity context, int resource, @NonNull ArrayList<POJO> objects) {
        super(context,R.layout.row,objects);
        lst=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=convertView;
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=inflater.inflate(R.layout.row,null);
        TextView txtvw1=(TextView)v.findViewById(R.id.txtvw1);
        TextView txtvw2=(TextView)v.findViewById(R.id.txtvw2);
        txtvw2.setText(String.valueOf(lst.get(position).getTxtvw1()));
        txtvw1.setText(String.valueOf(lst.get(position).getTxtvw2()));
        return v;
    }
}
