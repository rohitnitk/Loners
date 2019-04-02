package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class crtpin extends AppCompatActivity {

    private EditText a1,a2,a3,a4,b1,b2,b3,b4;
    private Button b;
    private FirebaseAuth mAuth;
    private String currentUID;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crtpin);

        mAuth = FirebaseAuth.getInstance();
        currentUID = mAuth.getCurrentUser().getUid();

        a1=(EditText)findViewById(R.id.eto1);
        a2=(EditText)findViewById(R.id.eto2);
        a3=(EditText)findViewById(R.id.et3);
        a4=(EditText)findViewById(R.id.et4);
        b1=(EditText)findViewById(R.id.et5);
        b2=(EditText)findViewById(R.id.et6);
        b3=(EditText)findViewById(R.id.et7);
        b4=(EditText)findViewById(R.id.et8);
        b=(Button)findViewById(R.id.btk);

        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {

                                   if(validate()) {
                                       //database;
                                       sendPIN();
                                       Intent i=new Intent(crtpin.this,payview.class);
                                       startActivity(i);

                                   }
                                 }
                             }

                             );

    }

    private void sendPIN() {
        myRef = FirebaseDatabase.getInstance().getReference().child(currentUID);
        myRef.child("PIN").child("p1").setValue(a1.getText().toString());
        myRef.child("PIN").child("p2").setValue(a2.getText().toString());
        myRef.child("PIN").child("p3").setValue(a3.getText().toString());
        myRef.child("PIN").child("p4").setValue(a4.getText().toString());

    }

    private boolean validate()
    {
        Boolean r=false;
        String e1=a1.getText().toString();
        String e2=a2.getText().toString();
        String e3=a3.getText().toString();
        String e4=a4.getText().toString();
        String e5=b1.getText().toString();
        String e6=b2.getText().toString();
        String e7=b3.getText().toString();
        String e8=b4.getText().toString();
        if(!(e1.isEmpty())&&!(e2.isEmpty())&&!(e3.isEmpty())&&!(e4.isEmpty())&&!(e5.isEmpty())&&!(e6.isEmpty())&&!(e7.isEmpty())&&!(e8.isEmpty()))
        {
            if(e1.compareTo(e5)==0&&e2.compareTo(e6)==0&&e3.compareTo(e7)==0&&e4.compareTo(e8)==0)
            {
                Toast.makeText(this,"Pin is created successfully",Toast.LENGTH_SHORT).show();
                r=true;

            }
            else
            {
                Toast.makeText(this,"check password conformation",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this,"Please enter valid details",Toast.LENGTH_SHORT).show();

        }
       return r;
    }

}
