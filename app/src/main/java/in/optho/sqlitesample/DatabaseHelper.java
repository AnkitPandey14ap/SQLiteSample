package in.optho.sqlitesample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by krishna on 1/10/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String TAG="OPTHO";


    public static final String DATABASE_NAME ="Employes.db";
    public static final String TABLE_NAME ="employee_table";
    public static final String ID ="ID";
    public static final String PIN ="PIN";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (Sno text primary key autoincrement, ID text, pin text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exist "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insterData(String id, String pin){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(PIN,pin);

        long result=db.insert(TABLE_NAME, null, contentValues);
        Log.i(TAG, "insterData: "+result);

        if(result== -1){
            return false;
        }
        else{
            return true;
        }

    }
}
