package Fragments;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import ro.khai_quest.BarcodeReader;
import ro.khai_quest.R;


public class ScannerFragment extends Fragment
{

    public ScannerFragment()
    {
        // Required empty public constructor
    }

    private String result;
    public void setResult(String result)
    {
        this.result = result;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.scaner, container, false);

        ((TextView)(view.findViewById(R.id.textViewRezult))).setText(result);

        BarcodeReader br= new BarcodeReader(view.getContext(),getActivity());

        view.findViewById(R.id.buttonStart).setOnClickListener(view1 ->
        {
            try
            {
                br.startRead();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });

        return view;
    }

}