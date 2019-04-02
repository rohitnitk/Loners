package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class crdview extends AppCompatActivity {

    private EditText acc_no, cum_name,mnth,year,cvv;
    private TextView pay;
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_crdview);
    acc_no=(EditText)findViewById(R.id.etacn);
    cum_name=(EditText)findViewById(R.id.etacn);
    mnth=(EditText)findViewById(R.id.etmnth);
    year=(EditText)findViewById(R.id.etyear);
    cvv=(EditText)findViewById(R.id.etcvv);
    pay=(TextView)findViewById(R.id.tvpay) ;

    pay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            validate(acc_no.getText().toString(),cum_name.getText().toString(),mnth.getText().toString(),year.getText().toString(),cvv.getText().toString());
        }

        });
}

private void validate(String acc_no,String cum_name,String mnth,String year,String cvv) {
    if(acc_no.isEmpty()||cum_name.isEmpty()||mnth.isEmpty()||year.isEmpty()||cvv.isEmpty())
    {

        Toast.makeText(this, "requirements are not finished ", Toast.LENGTH_SHORT).show();
    }
    else if(!(acc_no.isEmpty())&&!(cum_name.isEmpty())&&!(mnth.isEmpty())&&!(year.isEmpty())&&!(cvv.isEmpty()))
    {
        Intent i=new Intent(crdview.this,paid.class);
        startActivity(i);
    }
    }
private boolean validateacc_num()
{
    String acn=acc_no.getText().toString();
    if(acn.isEmpty())
    {
        acc_no.setError("Field can't be empty");
        return false;
    }
    else
    {
        acc_no.setError(null);
        return true;
    }
}
 private boolean validatecus()
 {
     String c_name=cum_name.getText().toString();
     if(c_name.isEmpty())
     {
         cum_name.setError("Field can't be empty");
         return false;
     }
     else
     {
         cum_name.setError(null);
         return true;
     }
 }
 private boolean validatemnth()
 {
     String mn=mnth.getText().toString();
     String ye=year.getText().toString();
     if(mn.isEmpty()||ye.isEmpty())
     {
         mnth.setError("Field can't be empty");

         return false;
     }
     else
     {
         mnth.setError(null);
         return true;
     }
 }
private boolean validatcvv()
{
    String cv=cvv.getText().toString();

    if(cv.isEmpty())
    {
        cvv.setError("Field can't be empty");
        return false;
    }
    else
    {
        cvv.setError(null);
        return true;
    }
}

}
