package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import RecyclerViews.MessageRecyclerAdapter;
import RecyclerViews.QrCodeRecyclerAdapter;
import myJurnal_DB.DB_Journal;
import ro.khai_quest.R;


public class MessageFragment extends Fragment
{
    private MessageRecyclerAdapter adapter;
    private LinearLayoutManager verticalLinearLayoutManager;

    public MessageFragment()
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
        adapter = new MessageRecyclerAdapter();
        View view = inflater.inflate(R.layout.fragment_messsage, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerMessages);
        verticalLinearLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(verticalLinearLayoutManager);

        recyclerView.setAdapter(adapter);

        DB_Journal db_journal = new DB_Journal(getActivity().getApplicationContext());
        db_journal.loadData();

        adapter.addAll(db_journal.getListQrCodes(),getActivity().getApplicationContext());
        adapter.notifyDataSetChanged();

        return view;
    }

}