package com.example.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RateApp extends AppCompatActivity{
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_app);

    b = (Button)findViewById(R.id.submitRate);
    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            temp();
        }
    });
    }

    private void temp() {
        Toast.makeText(this, "Thanks! Your response is recorded",Toast.LENGTH_SHORT).show();
        super.onBackPressed();

    }
}
