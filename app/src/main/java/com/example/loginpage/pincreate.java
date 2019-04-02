package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class pincreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pincreate);
    }

    public void crtpin(View view) {
        Intent i=new Intent(pincreate.this,crtpin.class);
        startActivity(i);
    }


    public void changepin(View view) {
        Intent i =new Intent(pincreate.this,changepin.class);
         startActivity(i);
    }

    public void fgtpin(View view) {
        Intent i =new Intent(pincreate.this,fgtpin.class);
        startActivity(i);
    }

}
