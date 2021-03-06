package myJurnal_DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Comparator;

import Entity.MyQrCode;

public class DB_Journal extends SQLiteOpenHelper
{
    static final String BD_NAME ="Journal";
    static final int VERSION =1;

    public DB_Journal(Context context)
    {
        super(context, BD_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("CREATE table QrCodePoint(id integer PRIMARY KEY autoincrement, x integer NOT NULL, y integer NOT NULL, message text NOT NULL, password  integer NOT NULL, isOpen  integer NOT NULL,UNIQUE(password));");
        //true 1
        // false 0
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
    public void loadData()
    {
        insert(0,0,"hello","02616018",false);
        insert(0,0,"hello2","2",false);
        insert(0,0,"hello3","3",false);
        insert(0,0,"hello4","4",false);
        insert(0,0,"hello5","5",false);
    }
    private void insert(final int x,final int y, String message, String password, boolean isOpen)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("x",x);
        contentValues.put("y",y);
        contentValues.put("message",message);
        contentValues.put("password",password);
        if (isOpen)
        contentValues.put("isOpen",1);
        else contentValues.put("isOpen",0);
        this.getWritableDatabase().insert("QrCodePoint",null,contentValues);
    }
    public ArrayList<MyQrCode> getListQrCodes()
    {
        ArrayList<MyQrCode> qrCodes = new ArrayList<MyQrCode>();

        Cursor cursor = this.getWritableDatabase().query("QrCodePoint", null, null, null, null, null, null);
        if (cursor.moveToFirst())
        {
            do {
                    if ((int) cursor.getInt(cursor.getColumnIndex("isOpen"))==1)
                    {
                        MyQrCode qrCode = new MyQrCode((int) cursor.getInt(cursor.getColumnIndex("id")), (int) cursor.getInt(cursor.getColumnIndex("x")),(int) cursor.getInt(cursor.getColumnIndex("y")),
                                (String) cursor.getString(cursor.getColumnIndex("message")),cursor.getString(cursor.getColumnIndex("password")),true);
                        qrCodes.add(qrCode);
                    }
                    else
                    if ((int) cursor.getInt(cursor.getColumnIndex("isOpen"))==0)
                    {
                        MyQrCode qrCode = new MyQrCode((int) cursor.getInt(cursor.getColumnIndex("id")), (int) cursor.getInt(cursor.getColumnIndex("x")),(int) cursor.getInt(cursor.getColumnIndex("y")),
                                (String) cursor.getString(cursor.getColumnIndex("message")),cursor.getString(cursor.getColumnIndex("password")),false);
                        qrCodes.add(qrCode);
                    }

                } while (cursor.moveToNext());
        }
        return qrCodes;
    }

    public void openQrCode(String password)
    {
        this.getWritableDatabase().execSQL("UPDATE QrCodePoint SET isOpen=1 WHERE password='"+password+"' ");
    }

}
