package in.optho.sqlitesample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "OPTHO";
    DatabaseHelper myDb;

    private SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDb = new DatabaseHelper(this);

        sharedpreferences = getSharedPreferences("EMPLOYEES", Context.MODE_PRIVATE);

        boolean dataIsSaved = sharedpreferences.getBoolean("dataIsSaved", false);
//        if(dataIsSaved)
            insert();


    }


    void insert(){

        boolean isInserted = false;
        try{

            isInserted = myDb.insterData("12","2222");
            isInserted = myDb.insterData("13","3333");
            isInserted = myDb.insterData("14","4444");
            isInserted = myDb.insterData("15","5555");
            isInserted = myDb.insterData("16","6666");

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean("dataIsSaved", true);
            editor.commit();

            Toast.makeText(this, "edit "+ isInserted, Toast.LENGTH_SHORT).show();



        }catch (Exception e){
            Toast.makeText(this, "e "+isInserted, Toast.LENGTH_SHORT).show();
            Log.i(TAG, "onCreate: "+isInserted);
        }
    }
}
