

//my code
package com.example.loginpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ImageView image;
    private EditText emailinput;
    private EditText password;
    private TextView info, signin_button, forgot_button, error_username, error_password;
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.etimage);
        emailinput = (EditText) findViewById(R.id.etemail);
        password = (EditText) findViewById(R.id.etpassword);
        info = (TextView) findViewById(R.id.tvinfo);
        login = (Button) findViewById(R.id.btnlogin);
        signin_button = (TextView) findViewById(R.id.tvsign);
        forgot_button = (TextView) findViewById(R.id.tvforgot);
        error_username = (TextView) findViewById(R.id.eterror1);
        error_password = (TextView) findViewById(R.id.eterror2);

        //info.setText("no of attemps remaining:5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(emailinput.getText().toString(), password.getText().toString());
            }
        });

        signin_button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, sup.class));
            }
        });

        forgot_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PasswordActivity.class));
            }
        });


    }

    @SuppressLint("SetTextI18n")
    private void validate(String emailinput, String userpassword) {
        boolean a;
        int b;

        if (emailinput.isEmpty()) {
            error_username.setText("*field is empty");


        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailinput).matches()) {
            error_username.setText("*please enter valid email address");


        } else {
            error_username.setText("");
        }

        //password

        if (userpassword.isEmpty()) {

            error_password.setText("*field is empty");

        } else {
            error_password.setText("");
        }


        if (Patterns.EMAIL_ADDRESS.matcher(emailinput).matches() && !userpassword.isEmpty()) {

            if (emailinput.equals("satish@gmail.com") && userpassword.equals("12345")) {


                Intent intent = new Intent(MainActivity.this, Organizer.class);
                startActivity(intent);
                return;
            } else if (emailinput.equals("sanath@gmail.com") && userpassword.equals("12345")) {

                Intent intent1 = new Intent(MainActivity.this, userdashboard.class);
                startActivity(intent1);
                return;
            } else {
                error_password.setText("*user name or password is wrong");
                error_username.setText("");

                counter--;
                info.setText("                        no of attemps left:" + counter);
            }


            if (counter == 0) {
                login.setEnabled(false);
            }
        }
    }
  /*  public void openOrg(View view)
    {
        Intent i = new Intent(MainActivity.this, signup.class);
        startActivity(i);
    }*/


}







