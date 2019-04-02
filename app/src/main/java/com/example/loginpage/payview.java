package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class payview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payview);
    }

    public void add1(View view) {
        Intent i=new Intent(payview.this,add.class);
         startActivity(i);
    }

    public void viewpay(View view) {
        Intent i=new Intent(payview.this,pay.class);
        startActivity(i);
    }

    public void viewhistory(View view) {
        Intent i=new Intent(payview.this,history.class);
        startActivity(i);
    }

    public void balanceview(View view) {
        Intent i=new Intent(payview.this,balance.class);
        startActivity(i);
    }

    public void pin(View view) {
        Intent i=new Intent(payview.this,pincreate.class);
        startActivity(i);
    }
}
