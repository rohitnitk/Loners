package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class personal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        Button btn1 =(Button)findViewById(R.id.a1);
        Button btn2 =(Button)findViewById(R.id.a2);
        Button btn3=(Button)findViewById(R.id.a3);
        btn1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(personal.this,activity.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(personal.this,activity.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(personal.this,activity.class));
            }
        });

    }
}
