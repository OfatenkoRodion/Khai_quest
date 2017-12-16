package Fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import myJurnal_DB.DB_Journal;
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
        View view = inflater.inflate(R.layout.fragment_start_scaner, container, false);

        if (result!=null)
        {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss");
            ((TextView)(view.findViewById(R.id.textViewRezult))).setText(formatForDateNow.format(dateNow) +" считано:"+result);

            DB_Journal db_journal = new DB_Journal(getActivity().getApplicationContext());
            try
            {
                db_journal.openQrCode(Integer.parseInt(result));
            }
            catch (NumberFormatException e)
            {
                ((TextView)(view.findViewById(R.id.textViewRezult))).setText("Считывайте только коды участвующие в игре, результат считывания :\r\n" +
                        formatForDateNow.format(dateNow) +" "+result);
            }
        }

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