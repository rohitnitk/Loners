package com.example.loginpage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class OrgProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_profile);
    }

    public void edit_clicked(View view) {
        EditText name = (EditText) findViewById(R.id.textView_name);
        EditText email = (EditText) findViewById(R.id.email);
        EditText phone = (EditText) findViewById(R.id.phone);
        EditText dob = (EditText) findViewById(R.id.dob);


        name.setFocusable(true);
        name.setFocusableInTouchMode(true);
        email.setFocusable(true);
        email.setFocusableInTouchMode(true);
        phone.setFocusable(true);
        phone.setFocusableInTouchMode(true);
        dob.setFocusable(true);
        dob.setFocusableInTouchMode(true);
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.female:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.male:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

}
