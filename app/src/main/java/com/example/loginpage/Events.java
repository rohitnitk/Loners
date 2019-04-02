package com.example.loginpage;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Events extends AppCompatActivity {

    private RecyclerView postList;
    private Toolbar mToolbar;

    private DatabaseReference EventsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Event");

        EventsRef = FirebaseDatabase.getInstance().getReference().child("Events");

        postList = (RecyclerView) findViewById(R.id.all_user_event_list);
        postList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        postList.setLayoutManager(linearLayoutManager);


        DisplayAllUsersPosts();
    }

    private void DisplayAllUsersPosts() {
        FirebaseRecyclerAdapter<PostEvents,EventsViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<PostEvents, EventsViewHolder>
                        (
                                PostEvents.class,
                                R.layout.all_events_layout,
                                EventsViewHolder.class,
                                EventsRef
                        )
                {
                    @Override
                    protected void populateViewHolder(EventsViewHolder viewHolder, PostEvents model, int position) {
                        final String EventKey = getRef(position).getKey();

                        viewHolder.setFullname(model.getFullname());
                        viewHolder.setDate(model.getDate());
                        viewHolder.setTime(model.getTime());
                        viewHolder.setDescription(model.getDescription());
                        viewHolder.setEventimage(getApplicationContext(), model.getEventimage());
                    }
                };
        postList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public EventsViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setDate(String date){
            TextView PostDate = (TextView) mView.findViewById(R.id.event_date);
            PostDate.setText("   " + date);
        }

        public void setDescription(String description){
            TextView PostDescription = (TextView) mView.findViewById(R.id.event_description);
            PostDescription.setText(description);
        }

        public void setFullname(String fullname){
            TextView username = (TextView) mView.findViewById(R.id.event_user_name);
            username.setText(fullname);
        }

        public void setEventimage(Context ctx, String eventimage){
            ImageView EventImage = (ImageView) mView.findViewById(R.id.event_image);
            Picasso.get().load(eventimage).into(EventImage);
        }

        public void setTime(String time){
            TextView PostTime = (TextView) mView.findViewById(R.id.event_time);
            PostTime.setText("   " + time);
        }
    }

    public void newEvent(View view) {
        startActivity(new Intent(Events.this, EventActivity.class));
    }
}
