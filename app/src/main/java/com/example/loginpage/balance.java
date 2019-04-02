package com.example.loginpage;

import android.os.Bundle;
<<<<<<< HEAD
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class balance extends AppCompatActivity {

    private TextView info;
    private FirebaseAuth mAuth;
    private String currentUID;
    private String g;
    private DatabaseReference myRef1;
   // private String bal;
=======
import android.support.v7.app.AppCompatActivity;

public class balance extends AppCompatActivity {

>>>>>>> 5bb075d42880bddc8cfac6f7bf6c7a00eebd06f5
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
<<<<<<< HEAD
        mAuth = FirebaseAuth.getInstance();
        currentUID = mAuth.getCurrentUser().getUid();
        info = (TextView) findViewById(R.id.tvinfo1);
        myRef1=FirebaseDatabase.getInstance().getReference().child(currentUID).child("BALANCE");
        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                 }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
 });
        info.setText("Balance in your wallet is: " +g);
    }


=======
    }
>>>>>>> 5bb075d42880bddc8cfac6f7bf6c7a00eebd06f5
}
