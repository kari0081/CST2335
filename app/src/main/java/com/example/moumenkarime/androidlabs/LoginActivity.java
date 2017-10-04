package com.example.moumenkarime.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends Activity {
    private EditText loginInputEmail;
    private Button btnlogin;
    protected static final String ACTIVITY_NAME = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        loginInputEmail = (EditText) findViewById(R.id.login_input_email);
        SharedPreferences sharedPref = getSharedPreferences("Login_input_email", Context.MODE_PRIVATE);
        String name = sharedPref.getString("Login_input_email", "email@domain.com");
        loginInputEmail.setText(name);

        btnlogin = (Button) findViewById(R.id.btn_login);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("Login_input_email", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                String input = loginInputEmail.getText().toString();
                editor.putString("Login_input_email", input);
                editor.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);


            }

        });

    }

        @Override
        protected  void onStart(){
            super.onStart();
            Log.i(ACTIVITY_NAME, "In onStart()");
        }

        @Override
        protected void onResume() {
            super.onResume();
            Log.i(ACTIVITY_NAME, "In onResume()");

        }

            @Override
            protected void onPause(){
                super.onPause();
                Log.i(ACTIVITY_NAME, "In onPause()");
            }

            @Override
            protected void onStop(){
                super.onStop();
                Log.i(ACTIVITY_NAME, "In onStop()");
            }
            @Override
            protected void onDestroy(){
                super.onDestroy();
                Log.i(ACTIVITY_NAME, "In onDestroy)");
            }


    }




