package com.example.moumenkarime.androidlabs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.CompoundButton;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;






public class ListItemsActivity extends Activity {

    protected static final String ACTIVITY_NAME = "ListItemsActivity";
    ImageButton imgbtn= null;
     Switch sw = null;
    CheckBox chb= null;
     int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        imgbtn = (ImageButton) findViewById(R.id.mycamera);
        sw = (Switch) findViewById(R.id.switchobbject);
        chb = (CheckBox) findViewById(R.id.checkbox);

            imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 if( takePictureIntent.resolveActivity(getPackageManager()) != null)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);}

            });


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                CharSequence text = "Switch is off";//"Switch is on"
                int duration = Toast.LENGTH_SHORT;//= Toast.LENGTH_LONG
                Toast toast = Toast.makeText(getApplicationContext(),text,duration);
                toast.show();


            }


        });



        chb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                builder.setMessage(R.string.dialog_message);
                builder.setTitle(R.string.dialog_title);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {



                    public void onClick(DialogInterface dialog, int id) {

                        // User clicked OK button
                        Intent resultIntent = new Intent(  );
                        resultIntent.putExtra("Response", "Here is my response");
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();

                    }

                    });

            builder.setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialog, int id) {

                    // User cancelled the dialog
                }

                });

                    builder.show();
            }

            });



        }




    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgbtn.setImageBitmap(imageBitmap);}

    }


    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
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
