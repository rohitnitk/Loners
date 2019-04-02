package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class changepin extends AppCompatActivity {

    private   EditText a1,a2,a3,a4;
    private Button bt;
    private FirebaseAuth mAuth;
    private String currentUID, f1, f2, f3, f4;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepin);

        mAuth = FirebaseAuth.getInstance();
        currentUID = mAuth.getCurrentUser().getUid();

        a1=(EditText)findViewById(R.id.eto1);
        a2=(EditText)findViewById(R.id.eto2);
        a3=(EditText)findViewById(R.id.eto3);
        a4=(EditText)findViewById(R.id.eto4);

        bt=(Button)findViewById(R.id.btk2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 compare();
                if(validate())
                {
                    Intent i=new Intent(changepin.this,crtpin.class);
                    startActivity(i);
                }
            }
            }
        );
    }
    private void compare() {
        myRef = FirebaseDatabase.getInstance().getReference().child(currentUID).child("PIN");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                PIN pin1 = dataSnapshot.getValue(PIN.class);
                f1 = pin1.getP1();
                f2 = pin1.getP2();
                f3 = pin1.getP3();
                f4 = pin1.getP4();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(changepin.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean validate()
    {
        Boolean r=false;
        String c1=a1.getText().toString();
        String c2=a2.getText().toString();
        String c3=a3.getText().toString();
        String c4=a4.getText().toString();
        if(!(c1.isEmpty())&&!(c2.isEmpty())&&!(c3.isEmpty())&&!(c4.isEmpty()))
        {
             r=true;
           /* if((c1.compareTo(f1)==0)&&(c2.compareTo(f2)==0)&&(c3.compareTo(f3)==0)&&(c4.compareTo(f4)==0))
            {
                  r=true;
            }
            else
            {
                Toast.makeText(changepin.this, "Enter correct pin", Toast.LENGTH_SHORT).show();
            }*/
        }
        else
        {
            Toast.makeText(changepin.this, "Enter valid pin", Toast.LENGTH_SHORT).show();
        }
        return r;
    }

}
