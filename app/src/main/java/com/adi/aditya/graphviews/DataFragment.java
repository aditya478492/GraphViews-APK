package com.adi.aditya.graphviews;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class DataFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText et1=null;
    EditText et2=null;
    ImageButton btn=null;
    ListView lstvw=null;
    Button crtbtn=null;
    ArrayList<POJO> lst=new ArrayList<>();
    CustomAdapter adapter=null;
    Communicator comm;

    private OnFragmentInteractionListener mListener;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et1=(EditText)getView().findViewById(R.id.et1);
        et2=(EditText)getView().findViewById(R.id.et2);
        btn=(ImageButton)getView().findViewById(R.id.addbtn);
        lstvw=(ListView)getView().findViewById(R.id.lstvw);
        crtbtn=(Button)getView().findViewById(R.id.crtbtn);
        //lst=new ArrayList<POJO>();

        crtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comm.Respondb(lst);
                comm.Respond(lst);
                comm.Respondl(lst);
                Toast.makeText(getContext(), "Data Populated !!", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lst.add(new POJO(et1.getText().toString(),et2.getText().toString()));
                adapter.notifyDataSetChanged();
                lstvw.setAdapter(adapter);
            }
        });

        lstvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lst.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter=new CustomAdapter(getActivity(),R.layout.row,lst);
        comm=(Communicator)getActivity();
    }



    public DataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataFragment newInstance(String param1, String param2) {
        DataFragment fragment = new DataFragment();
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
        //lst=new ArrayList<POJO>();
        //adapter=new CustomAdapter(this,R.layout.row,lst);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
