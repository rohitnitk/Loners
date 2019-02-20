package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class sup extends AppCompatActivity {

    private EditText fname, lname, mail, mbl, pwd, cnfpwd;
    private TextView Sign_up, f, l, e, m, p, cp;
    public Button sbt;
    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
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

        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(fname.getText().toString(), lname.getText().toString(), mail.getText().toString(), mbl.getText().toString(), pwd.getText().toString(), cnfpwd.getText().toString());


            }
        });
    }

    private void validate(String fname, String lname, String mail, String mbl, String pwd, String cnfpwd) {

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
                    Intent intent = new Intent(sup.this, userdashboard.class);
                    startActivity(intent);
                    flag = 1;
                } else {
                    Intent intent = new Intent(sup.this, Organizer.class);
                    startActivity(intent);
                    flag = 1;
                }
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

        }


    }
