package com.example.loginpage;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
        startActivity(new Intent(this, history.class));
    }


    public void messenger(View view) {
        startActivity(new Intent(this, chatlogin.class));
    }

    public void createEvent(View v)
    {
        Intent i = new Intent(this,Events.class);
        startActivity(i);
    }

    public void ReceiveEvent(View view)
    {
        Intent i = new Intent(this,ReceiveEvent.class);
        startActivity(i);
    }

    public void Home(View view) {
        startActivity(new Intent(this, Home.class));
    }
    public void delete (View view){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(userdashboard.this, "your account has been deleted", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });

    }

    public void gotomoodTest(View view) {
        Intent j = new Intent(this, mood.class);
        startActivity(j);

    }
    private Boolean exit = false;
    @Override


    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
}