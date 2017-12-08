package ro.khai_quest;


import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


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
            br.startRead();

            Toast.makeText(this,br.getText(), Toast.LENGTH_SHORT).show();

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}

