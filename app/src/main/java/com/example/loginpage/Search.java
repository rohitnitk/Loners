//package com.example.loginpage;
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.squareup.picasso.Picasso;
//
//public class Search extends AppCompatActivity {
//
//    private EditText mSearchField;
//    private ImageButton mSearchBtn;
//
//    private RecyclerView mResultList;
//
//    private DatabaseReference mUserDatabase;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        mUserDatabase = FirebaseDatabase.getInstance().getReference("Users");
//
//
//        mSearchField = (EditText) findViewById(R.id.search_field);
//        mSearchBtn = (ImageButton) findViewById(R.id.search_btn);
//
//        mResultList = (RecyclerView) findViewById(R.id.result_list);
//        mResultList.setHasFixedSize(true);
//        mResultList.setLayoutManager(new LinearLayoutManager(this));
//
//        mSearchBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String searchText = mSearchField.getText().toString();
//
//             ///   firebaseUserSearch(searchText);
//
//            }
//        });
//
//    }
//
//
//
//
//    // View Holder Class
//
//    public static class UsersViewHolder extends RecyclerView.ViewHolder {
//
//        View mView;
//
//        public UsersViewHolder(View itemView) {
//            super(itemView);
//
//            mView = itemView;
//
//        }
//
//        public void setDetails(Context ctx, String userName, String userStatus, String userImage){
//
//            TextView user_name = (TextView) mView.findViewById(R.id.name_text);
//            TextView user_status = (TextView) mView.findViewById(R.id.status_text);
//            ImageView user_image = (ImageView) mView.findViewById(R.id.profile_image);
//
//
//            user_name.setText(userName);
//            user_status.setText(userStatus);
//
//            Picasso.get().load(userImage).into(user_image);
//
//        }
//
//
//
//
//    }
//
//}
