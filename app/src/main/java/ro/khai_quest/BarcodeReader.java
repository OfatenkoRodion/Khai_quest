package ro.khai_quest;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BarcodeReader implements ZXingScannerView.ResultHandler
{
    private static final int MY_PERMISSIONS_REQUESTS = 1;
    private ZXingScannerView mScannerView;
    private Context context;
    private Activity activity;

    public BarcodeReader(Context context, Activity activity)
    {
        this.context = context;
        this.activity = activity;
    }

    public void startRead() throws InterruptedException
    {
        if (checkPermissionOnCamera())
        {
            mScannerView = new ZXingScannerView(context);
            activity.setContentView(mScannerView);
            mScannerView.setResultHandler(this);
            mScannerView.startCamera();
        }
    }

    @Override
    public void handleResult(Result result)
    {
        mScannerView.removeAllViews();
        mScannerView.stopCamera();

        Intent intent =activity.getIntent();
        intent.putExtra("qr_code", result.getText());

        activity.finish();
        activity.startActivity(intent);
    }

    public boolean checkPermissionOnCamera()
    {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA))
            {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                alertBuilder.setCancelable(true);
                alertBuilder.setTitle("Permission necessary");
                alertBuilder.setMessage("CAMERA is necessary");
                alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions( activity,
                                new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
                    }
                });
                AlertDialog alert = alertBuilder.create();
                alert.show();
            }
            else
            {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUESTS);
            }
            return false;
        }
        else
        {
            return true;
        }
    }
}
