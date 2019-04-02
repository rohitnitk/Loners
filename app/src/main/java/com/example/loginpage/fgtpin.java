package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class fgtpin extends AppCompatActivity {

   private EditText a1,a2,a3,a4;
   private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fgtpin);

        a1=(EditText)findViewById(R.id.etf1);
        a2=(EditText)findViewById(R.id.etf2);
        a3=(EditText)findViewById(R.id.etf3);
        a4=(EditText)findViewById(R.id.etf4);
        bt=(Button)findViewById(R.id.btk3);

    }

    public void crtpin(View view) {
        Intent i=new Intent(fgtpin.this,crtpin.class);
        startActivity(i);
    }
}
