

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    private ImageView image;
    private EditText emailinput;
    private EditText userpassword;
    private TextView info, signin_button, forgot_button, error_username, error_password;
    private Button login;
    private int counter = 5;
    private FirebaseAuth firebaseAuth;
    public FirebaseDatabase firebaseDatabase;
    String is_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.etimage);
        emailinput = (EditText) findViewById(R.id.etemail);
        userpassword = (EditText) findViewById(R.id.etpassword);
        info = (TextView) findViewById(R.id.tvinfo);
        login = (Button) findViewById(R.id.btnlogin);
        signin_button = (TextView) findViewById(R.id.tvsign);
        forgot_button = (TextView) findViewById(R.id.tvforgot);
        error_username = (TextView) findViewById(R.id.eterror1);
        error_password = (TextView) findViewById(R.id.eterror2);

        //info.setText("no of attemps remaining:5");

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user!=null){
            finish();
            firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserData userData = dataSnapshot.getValue(UserData.class);
                    if(userData.getIsuser().compareTo("true")==0)
                        startActivity(new Intent(MainActivity.this, userdashboard.class));
                    else
                        startActivity(new Intent(MainActivity.this, Organizer.class));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(emailinput.getText().toString(), userpassword.getText().toString());
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

    private void validate(String userName, String userPassword) {



        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            UserData userData = dataSnapshot.getValue(UserData.class);
                            if(userData.getIsuser().compareTo("true")==0)
                                startActivity(new Intent(MainActivity.this, userdashboard.class));
                            else
                                startActivity(new Intent(MainActivity.this, Organizer.class));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    counter--;
                    info.setText("No of attempts remaining: " + counter);

                    if(counter == 0){
                        login.setEnabled(false);
                    }
                }
            }
        });


    }
  /*  public void openOrg(View view)
    {
        Intent i = new Intent(MainActivity.this, signup.class);
        startActivity(i);
    }*/


}







