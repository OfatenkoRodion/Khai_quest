package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import RecyclerViews.QrCodeRecyclerAdapter;
import myJurnal_DB.DB_Journal;
import ro.khai_quest.R;


public class QrCodesFragment extends Fragment
{
    private QrCodeRecyclerAdapter adapter;

    public QrCodesFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        adapter = new QrCodeRecyclerAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_qr_codes, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewQrCodes);
        recyclerView.setAdapter(adapter);

        try
        {
            DB_Journal db_journal= new DB_Journal(view.getContext());
            adapter.addAll(db_journal.getListQrCodes());
        }
        catch (Exception e)
        {
            Toast.makeText(view.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }


        return view;
    }

}