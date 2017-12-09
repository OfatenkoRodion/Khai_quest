package myJurnal;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        sqLiteDatabase.execSQL("CREATE table Journal(id integer PRIMARY KEY autoincrement, x integer NOT NULL, y integer NOT NULL, message text NOT NULL, password  integer NOT NULL, isOpen  integer NOT NULL,UNIQUE(password));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
    private void insert(final int x,final int y, String message, int password, boolean isOpen)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("x",x);
        contentValues.put("y",y);
        contentValues.put("message",message);
        contentValues.put("password",password);
        if (isOpen)
        contentValues.put("isOpen",1);
        else contentValues.put("isOpen",0);

        this.getWritableDatabase().insert("Journal",null,contentValues);
    }
}
