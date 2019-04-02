package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pay1 extends AppCompatActivity {

     EditText mny,mbl;
     Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay1);
        mbl=(EditText)findViewById(R.id.etmb);
        mny=(EditText)findViewById(R.id.etmn);
        bt=(Button)findViewById(R.id.btk5);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    //Toast.(this,"Paid successfully",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(pay1.this,paid.class);
                    startActivity(i);
                }
            }
        });
    }
    private boolean validate()
    {
        boolean r=false;
        String a1=mbl.getText().toString();
        String a2=mny.getText().toString();
        if(!(a1.isEmpty())&&!(a2.isEmpty())&&a1.length()==10)
        {
            r=true;
        }
        return r;
    }
}
