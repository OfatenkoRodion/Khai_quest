package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.khai_quest.R;


public class QrCodesFragment extends Fragment
{

    public QrCodesFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_qr_codes, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewQrCodes);


        return view;
    }

}