package com.example.loginpage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class contactAndSupport extends AppCompatActivity {
   protected EditText Issue_description;
   private Button contact_support_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_and_support);

        Issue_description = (EditText)findViewById(R.id.Issue_description);
        contact_support_button = (Button)findViewById(R.id.contact_support_button);


        contact_support_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg();
            }
        });




}

    private void msg() {
        Toast.makeText(this, "Submitted Successfully, Thank You!", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

}