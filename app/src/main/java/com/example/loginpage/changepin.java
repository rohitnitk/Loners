package com.example.loginpage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class changepin extends AppCompatActivity {

    private   EditText a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepin);
        a1=(EditText)findViewById(R.id.eto1);
        a2=(EditText)findViewById(R.id.eto2);
        a3=(EditText)findViewById(R.id.eto3);
        a4=(EditText)findViewById(R.id.eto4);
        b1=(EditText)findViewById(R.id.etn1);
        b2=(EditText)findViewById(R.id.etn2);
        b3=(EditText)findViewById(R.id.etn3);
        b4=(EditText)findViewById(R.id.etn4);
        c1=(EditText)findViewById(R.id.etc1);
        c2=(EditText)findViewById(R.id.etc2);
        c3=(EditText)findViewById(R.id.etc3);
        c4=(EditText)findViewById(R.id.etc4);
        bt=(Button)findViewById(R.id.btk2);
    }

  //  bt.OnClickListener()

}
