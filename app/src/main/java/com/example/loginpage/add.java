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

<<<<<<< HEAD
       mAuth = FirebaseAuth.getInstance();
=======
        mAuth = FirebaseAuth.getInstance();
>>>>>>> 5bb075d42880bddc8cfac6f7bf6c7a00eebd06f5
        currentUID = mAuth.getCurrentUser().getUid();

        amount=(EditText)findViewById(R.id.etmny);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
               amt = amount.getText().toString();
               if(validate(amount.getText().toString()))
               {
                   addMoney();
=======
                amt = amount.getText().toString();
               if(validate(amount.getText().toString()))
               {
                   myRef = FirebaseDatabase.getInstance().getReference().child(currentUID);
                   myRef.child("Balance").setValue(amt);
>>>>>>> 5bb075d42880bddc8cfac6f7bf6c7a00eebd06f5
                Intent i=new Intent(add.this,card.class);
                startActivity(i);
               }
    }
<<<<<<< HEAD

        });
        }

    private void addMoney() {
        myRef = FirebaseDatabase.getInstance().getReference().child(currentUID);
        myRef.child("BALANCE").setValue(amt);
    }

=======
            });
        }

>>>>>>> 5bb075d42880bddc8cfac6f7bf6c7a00eebd06f5
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
