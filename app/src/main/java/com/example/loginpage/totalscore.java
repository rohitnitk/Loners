package com.example.loginpage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.loginpage.moodtest.total;

public class totalscore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totalscore);


        TextView result = (TextView)findViewById(R.id.result);
        TextView result2 = (TextView)findViewById(R.id.result2);
        Button button2 = (Button) findViewById(R.id.button2);

        result.setText("Your toal scrore is "+ total);



        if(total<50)
        {

            result2.setText("Your results suggest you may be suffering from severe depression.it would linkey be benificial for you to consult your doctor " +
                    "or a trained mental professional immediately\n You can also chat with Psychiatrist/Doctor by clinking below button");



        }
        if(total>50&&total<70)
        {

            result2.setText("Your results suggest you may be suffering from moderate depression.\nYou can start a convertion with doctor");



        }

        if(total>70&&total<90)
        {
            result2.setText("YOur results suggest minimal or no symptoms of depression");

            button2.setVisibility(View.GONE);

        }
        if(total==100)
        {
            result2.setText("you are fully health");

            button2.setVisibility(View.GONE);

        }
    }


    public void chat(View view) {
        finish();
        Intent i = new Intent(getApplicationContext(),chatlogin.class);

        startActivity(i);

    }

    public void backbutton(View view) {
        finish();
        Intent i = new Intent(getApplicationContext(), mood2.class);
        startActivity(i);
    }




    public void calltoDoctor(View view) {

        //  String posted_by = "111-333-222-4";
//        String posted_by = "990-231-332-4";
//        String uri = "tel:" + posted_by.trim() ;
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        intent.setData(Uri.parse(uri));
//        startActivity(intent);
        //Intent intent = new Intent(Intent.ACTION_DIAL);
        //intent.setData(Uri.parse("tel:0123456789"));
        //startActivity(intent);
        String phone = "+9902313324";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }
}
