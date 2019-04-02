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

public class pay extends AppCompatActivity {

    private EditText a1,a2,a3,a4;
    private Button bt;
    private FirebaseAuth mAuth;
    private String currentUID, c1, c2, c3, c4;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        mAuth = FirebaseAuth.getInstance();
        currentUID = mAuth.getCurrentUser().getUid();

        a1=(EditText)findViewById(R.id.etp1);
        a2=(EditText)findViewById(R.id.etp2);
        a3=(EditText)findViewById(R.id.etp3);
        a4=(EditText)findViewById(R.id.etp4);
        bt=(Button)findViewById(R.id.btk4);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compare();
                if(validate())
                {
                    Intent i=new Intent(pay.this,pay1.class);
                    startActivity(i);
                }
            }
        });

    }

    private void compare() {
        myRef = FirebaseDatabase.getInstance().getReference().child(currentUID).child("PIN");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                PIN pin = dataSnapshot.getValue(PIN.class);
                c1 = pin.getP1();
                c2 = pin.getP2();
                c3 = pin.getP3();
                c4 = pin.getP4();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(pay.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validate()
    {
        boolean r=false;
     String b1=a1.getText().toString();
     String b2=a2.getText().toString();
     String b3=a3.getText().toString();
     String b4=a4.getText().toString();

     if(!(b1.isEmpty())&&!(b2.isEmpty())&&!(b3.isEmpty())&&!(b4.isEmpty()))
     {
         if((b1.compareTo(c1)==0)&&(b2.compareTo(c2)==0)&&(b3.compareTo(c3)==0)&&(b4.compareTo(c4)==0))
         {r=true;}
         else
         {
             Toast.makeText(pay.this, "Enter correct pin", Toast.LENGTH_SHORT).show();
         }
     }
     else
     {
         Toast.makeText(pay.this, "Enter correct details", Toast.LENGTH_SHORT).show();
     }
        return  r;
        }
}
