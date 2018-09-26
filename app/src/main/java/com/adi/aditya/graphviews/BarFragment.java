package com.adi.aditya.graphviews;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static ArrayList<POJO> lst1;
    static ArrayList<BarEntry> entriesb;
    BarChart bchart;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BarFragment newInstance(String param1, String param2) {
        BarFragment fragment = new BarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        lst1=new ArrayList<POJO>();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bar, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            try{
                bchart=(BarChart)getView().findViewById(R.id.bchart);
                BarDataSet dataSet=new BarDataSet(entriesb,"lstb");
                BarData data=new BarData(dataSet);
                bchart.setData(data);
               /* bchart=(BarChart)getView().findViewById(R.id.bchart);

                ArrayList<BarEntry> entriesb=new ArrayList();
                for(int i=0;i<lst1.size();i++){
                    entriesb.add(new BarEntry(lst1.get(i).getTxtvw1(),lst1.get(i).getTxtvw2()));
                    Log.i("msg","listing items are adding");
                }
                Log.i("msg","size of bar entry list"+entriesb.size());
                BarDataSet dataSet=new BarDataSet(entriesb,"lst");
                BarData data=new BarData(dataSet);
                bchart.setData(data);
                Log.i("msg","bar chart should be populated");*/
            }
            catch (Exception e){e.printStackTrace();}
        }
        else {
        }
    }

    public void Transfer(ArrayList<POJO> lst){
        this.lst1=lst;


        entriesb=new ArrayList();
        for(int i=0;i<lst1.size();i++){
            entriesb.add(new BarEntry(lst1.get(i).getTxtvw1(),lst1.get(i).getTxtvw2()));
            Log.i("msg","listing items are adding");
        }
        Log.i("msg","size of bar entry list"+entriesb.size());

    }




    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
