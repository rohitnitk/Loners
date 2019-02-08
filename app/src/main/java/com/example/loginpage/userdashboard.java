package com.example.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userdashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdashboard);
    }

    public void user_profile(View view) {
        startActivity(new Intent(this, userprofile.class));
    }

    public void activity_page(View view) {
        startActivity(new Intent(this, personal.class));
    }


    public void messenger(View view) {
        startActivity(new Intent(this, chatpage.class));
    }

    public void createEvent(View v)
    {
        Intent i = new Intent(this,createEvent.class);
        startActivity(i);
    }

    public void ReceiveEvent(View view)
    {
        Intent i = new Intent(this,ReceiveEvent.class);
        startActivity(i);
    }
}
