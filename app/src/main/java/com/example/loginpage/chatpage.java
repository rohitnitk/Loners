package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

import com.example.loginpage.adapter.MessageAdapter;
import com.example.loginpage.model.ResponseMessage;
import com.example.loginpage.model.profile;

public class chatpage extends AppCompatActivity {

    EditText userInput;
    RecyclerView recyclerView;
    MessageAdapter messageAdapter;
    List<ResponseMessage> responseMessageList;
    ImageView backbutton;
    Button profilebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatpage);
        userInput = findViewById(R.id.userInput);
        recyclerView = findViewById(R.id.conversation);
        backbutton=findViewById(R.id.backbutton);
        profilebutton=findViewById(R.id.profilebutton);

        responseMessageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(responseMessageList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(messageAdapter);

        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEND) {

                    if((userInput.getText().toString().isEmpty())!=true ){
                        ResponseMessage responseMessage = new ResponseMessage(userInput.getText().toString(), true);
                        responseMessageList.add(responseMessage);
                        ResponseMessage responseMessage2 = new ResponseMessage(userInput.getText().toString(), false);

                        responseMessageList.add(responseMessage2);
                        messageAdapter.notifyDataSetChanged();
                        if (!isLastVisible())
                            recyclerView.smoothScrollToPosition(messageAdapter.getItemCount() - 1);

                    }
                }
                return false;
            }
        });


        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(chatpage.this,profile.class));
            }
        });


        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(chatpage.this,backbutton.class));

            }
        });


    }
    boolean isLastVisible() {
        LinearLayoutManager layoutManager = ((LinearLayoutManager) recyclerView.getLayoutManager());
        int pos = layoutManager.findLastCompletelyVisibleItemPosition();
        int numItems = recyclerView.getAdapter().getItemCount();
        return (pos >= numItems);
    }
}
