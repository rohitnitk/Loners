package com.example.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class forgotpassword extends AppCompatActivity {
    private Button btn;
    private TextView tet;boolean a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        btn = (Button) findViewById(R.id.etforgot);
        tet = (TextView) findViewById(R.id.editText4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    validat(tet.getText().toString());
                }
        });
    }

    private void validat(String tet){

        if(tet.isEmpty()){
            Toast.makeText(this,"email cannot be empty",Toast.LENGTH_LONG).show();
            return;
        }
        else if( a = tet.lastIndexOf("@gmail.com")==-1&&tet.length()!=0)
        {
            Toast.makeText(this,"email should be of the form abc@bcd.com",Toast.LENGTH_LONG).show();
            return;
        }
        else {
            Intent intent = new Intent(forgotpassword.this,verification.class);
            startActivity(intent);
        }
    }
}
