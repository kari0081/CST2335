package com.example.moumenkarime.androidlabs;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class StartActivity extends Activity {

    private Button Actbutton;


    protected static final String ACTIVITY_NAME = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In onCreate()");

       Actbutton = (Button) findViewById(R.id.activity_button);

        Actbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
                startActivityForResult(intent,10);}


        });}

    public void onActivityResult(int requestCode, int responseCode, Intent data) {
        if (requestCode == 10) {
            Log.i(ACTIVITY_NAME, "Returned to StartActivity onActivityResult");}

         if (responseCode==Activity.RESULT_OK){

            CharSequence text = (CharSequence) data.getStringExtra("Response");

            //CharSequence text = "ListItemsActivity passed:" + " My information to share";// "Switch is Off"
            int duration = Toast.LENGTH_LONG; //= Toast.LENGTH_LONG if Off

            Toast toast = Toast.makeText(getApplicationContext() ,text, duration); //this is the ListActivity
            toast.show(); //display your message box
        }





    }

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");

    }

    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy)");
    }




}
