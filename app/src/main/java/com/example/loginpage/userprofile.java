package com.example.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

public class userprofile extends AppCompatActivity {

    EditText name,mail,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        mail = findViewById(R.id.mail);
        name.setEnabled(false);
        mail.setEnabled(false);
        phone.setEnabled(false);
    }

    public void edit(View view) {
        name.setEnabled(true);
        mail.setEnabled(true);
        phone.setEnabled(true);
        name.setInputType(InputType.TYPE_CLASS_TEXT);
        phone.setInputType(InputType.TYPE_CLASS_NUMBER);
        mail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
    }
}
