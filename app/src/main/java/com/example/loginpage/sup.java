package com.example.loginpage;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.io.File;
import java.io.IOException;

public class sup extends AppCompatActivity {

    private EditText fname, lname, mail, mbl, pwd, cnfpwd;
    private TextView Sign_up, f, l, e, m, p, cp;
    public Button sbt;
    public RadioButton button1, button2;
    private int flag;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    String user_email, user_password, user_fname, user_lname, user_mobile;
    String user, org;
    FirebaseUser user2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        flag=0;
        fname = (EditText) findViewById(R.id.etname);
        lname = (EditText) findViewById(R.id.etname2);
        mail = (EditText) findViewById(R.id.etmail);
        mbl = (EditText) findViewById(R.id.etmbl);
        pwd = (EditText) findViewById(R.id.etpwd);
        cnfpwd = (EditText) findViewById(R.id.etcnfpwd);
        Sign_up = (TextView) findViewById(R.id.Sign_in);
        sbt = (Button) findViewById(R.id.btn);
        f = (TextView) findViewById(R.id.etf);
        l = (TextView) findViewById(R.id.etl);
        m = (TextView) findViewById(R.id.tvm);
        e = (TextView) findViewById(R.id.tve);
        p = (TextView) findViewById(R.id.tvp);
        cp = (TextView) findViewById(R.id.tvcp);

        button1 = (RadioButton) findViewById(R.id.loner);
        button2 = (RadioButton) findViewById(R.id.organizer);

        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( validate(fname.getText().toString(), lname.getText().toString(), mail.getText().toString(), mbl.getText().toString(), pwd.getText().toString(), cnfpwd.getText().toString())== 1){
                    user_email = mail.getText().toString().trim();
                    user_password = pwd.getText().toString().trim();
                    user_fname = fname.getText().toString().trim();
                    user_lname = lname.getText().toString().trim();
                    user_mobile = mbl.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                sendUserData();

                                Toast.makeText(sup.this, "Registration Successfull!", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(sup.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                };


            }
        });
    }

    private int validate(String fname, String lname, String mail, String mbl, String pwd, String cnfpwd) {

        if (fname.isEmpty()) {
            f.setText("*");
        } else {
            f.setText("");
        }
        if (lname.isEmpty()) {
            l.setText("*");
        } else {
            l.setText("");
        }
        if (mail.isEmpty() || !(Patterns.EMAIL_ADDRESS.matcher(mail).matches())) {
            e.setText("*");
        } else {
            e.setText("");
        }
        if (mbl.isEmpty() || !(mbl.length() == 10)) {
            m.setText("*");
        } else {
            m.setText("");
        }
        if (pwd.isEmpty() ||(pwd.length()<5)) {
            p.setText("*");
        } else {
            p.setText("");
        }
        if (cnfpwd.isEmpty()) {
            cp.setText("*");
        } else {
            cp.setText("");
        }
        if (!(fname.isEmpty()) && !(lname.isEmpty()) && !(mail.isEmpty()) && !(mbl.isEmpty()) && !(pwd.isEmpty()) && !(cnfpwd.isEmpty()) && (mbl.length() == 10) &&(pwd.length()>=5)) {
            if (pwd.equals(cnfpwd) && (Patterns.EMAIL_ADDRESS.matcher(mail).matches())) {
                RadioButton button = (RadioButton) findViewById(R.id.loner);

                if (button.isChecked()) {
                    Intent intent = new Intent(sup.this, MainActivity.class);
                    startActivity(intent);
                    flag = 1;
                    user = "true";


                } else {
                    Intent intent = new Intent(sup.this, MainActivity.class);
                    startActivity(intent);
                    flag = 1;
                    user = "false";
                }
                return 1;
            }
            //Intent intent = new Intent(sup.this, Mainpage.class);
            //startActivity(intent);}
            else {
                Toast.makeText(this, "re enter the password", Toast.LENGTH_SHORT).show();
            }
        }
        if (fname.isEmpty() || lname.isEmpty() || mail.isEmpty() || mbl.isEmpty() || pwd.isEmpty() || cnfpwd.isEmpty()) {
            Toast.makeText(this, "requirements are not finished ", Toast.LENGTH_SHORT).show();
        }
        return 0;

    }

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserData userData = new UserData(user_fname, user_lname, user_email, user_mobile,user);
        myRef.setValue(userData);


        Toast.makeText(sup.this, "Registration Successfull!", Toast.LENGTH_SHORT).show();

        //


        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!= null)
        {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(user_fname)
                    //.setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))  // here you can set image link also.
                    .build();

            user.updateProfile(profileUpdates)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("TESTING", "User profile updated.");
                            }
                        }
                    });
        }

        FirebaseUser user2 = firebaseAuth.getCurrentUser();
        String UserID=user2.getEmail().replace("@","").replace(".","");
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

        DatabaseReference ref1= mRootRef.child("Users").child(UserID);

        ref1.child("Name").setValue(user_fname);
        ref1.child("Image_Url").setValue("Null");
        ref1.child("Email").setValue(user_email);

        //



    }

}