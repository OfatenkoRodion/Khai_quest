package ro.khai_quest;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import rx.subjects.AsyncSubject;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void QrScanner(View view)
    {
        try
        {
            BarcodeReader br= new BarcodeReader(this,MainActivity.this);
            br.getText().subscribe( v -> {

                Toast.makeText(this,v, Toast.LENGTH_SHORT).show();
                ((TextView)(findViewById(R.id.textSimple))).setText(v);

            });
            br.startRead();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

}

