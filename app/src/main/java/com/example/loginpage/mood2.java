package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class mood2 extends AppCompatActivity {



    TextView questionTestview;
    RadioButton optionB1,optionB2,optionB3,optionB4;
    RadioGroup rg;
    int no = 0;
    public static int total, total2, total3;

    String [] questions = new String[] {
            "1.over the last 2 weeks, how often have you been bothered by..\nlittle interest or pleasure in doing things",
            "2.over the last 2 weeks, how often have you been bothered by..\nFeeling down,depresses,or hopeless",
            "3.over the last 2 weeks, how often have you been bothered by..\nTrouble falling or staying asleep,or sleeping too much",
            "4. over the last 2 weeks, how often have you been bothered by..\nFelling tired or having little energy",
            "5.over the last 2 weeks, how often have you been bothered by..\nPoor appetite or overreating",

    };

    String [] options = new String[] {
            "Not at all","several days","More then half the days","nearly everty day",

    };

    String [] ansfor = new String[] {
            "5",
            "syahadat",
            "sholat",
            "Al-Qur'an",
            "Muhammad SAW",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood2);

        questionTestview = findViewById(R.id.questionTestview);
        rg = findViewById(R.id.radio);
        optionB1 = findViewById(R.id.option1);
        optionB2 = findViewById(R.id.option2);
        optionB3 = findViewById(R.id.option3);
        optionB4 = findViewById(R.id.option4);


        questionTestview.setText(questions[no]);
        optionB1.setText(options[0]);
        optionB2.setText(options[1]);
        optionB3.setText(options[2]);
        optionB4.setText(options[3]);

        rg.check(0);
        total = 0;
        total2 = 0;




    }

    public void submit (View view)
    {
        if (optionB1.isChecked() || optionB2.isChecked() || optionB3.isChecked() || optionB4.isChecked())
        {
            if(optionB1.isChecked())
            {
                total=total+20;
            }
            if(optionB2.isChecked())
            {
                total=total+14;
            }
            if(optionB3.isChecked())
            {
                total=total+7;
            }
            if(optionB4.isChecked())
            {
                total=total+0;
            }

            RadioButton klik_jawaban = findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban = klik_jawaban.getText().toString();
            rg.check(0);
            if (ambil_jawaban.equalsIgnoreCase(ansfor[no])) total++;
            else total2++;
            no++;

            if (no < questions.length)
            {
                questionTestview.setText(questions[no]);
                optionB1.setText(options[0]);
                optionB2.setText(options[1]);
                optionB3.setText(options[2]);
                optionB4.setText(options[3]);

            }
            else
            {
                total3 = total * 20;

                Intent selesai = new Intent(getApplicationContext(),totalscore.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this, "select one option",Toast.LENGTH_SHORT).show();
        }
    }
}

