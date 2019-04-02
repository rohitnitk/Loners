package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add extends AppCompatActivity {

     private EditText amount;
     private Button btn;
    private FirebaseAuth mAuth;
    private String currentUID, amt;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_add);

       mAuth = FirebaseAuth.getInstance();
        currentUID = mAuth.getCurrentUser().getUid();

        amount=(EditText)findViewById(R.id.etmny);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               amt = amount.getText().toString();
               if(validate(amount.getText().toString()))
               {
                   addMoney();
                Intent i=new Intent(add.this,card.class);
                startActivity(i);
               }
    }

        });
        }

    private void addMoney() {
        myRef = FirebaseDatabase.getInstance().getReference().child(currentUID);
        myRef.child("BALANCE").setValue(amt);
    }

        private boolean validate(String amount)
        {
            boolean r = false;
          if(!amount.isEmpty())
          {
             r=true;
          }
          return r;
        }


}
