package com.example.loginpage;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class PostActivity extends AppCompatActivity {

    private ProgressDialog loadingBar;

    private ImageButton selectPostImage;
    private EditText postDescription;
    private Button updatePostButton;

    private static final int Gallery_Pick = 1;
    private Uri imageUri;
    private String description;

    private StorageReference postImageReference;
    private DatabaseReference usersRef, postRef;
    private FirebaseAuth mAuth;

    private String saveCurrentDate, saveCurrentTime, postRandomName, currentUID, downloadUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mAuth = FirebaseAuth.getInstance();
        currentUID = mAuth.getCurrentUser().getUid();

        postImageReference = FirebaseStorage.getInstance().getReference();
        usersRef = FirebaseDatabase.getInstance().getReference();
        postRef = FirebaseDatabase.getInstance().getReference().child("Posts");

        selectPostImage = (ImageButton) findViewById(R.id.selectPostImage);
        postDescription = (EditText) findViewById(R.id.postDescription);
        updatePostButton = (Button) findViewById(R.id.updatePostButton);
        loadingBar = new ProgressDialog(this);

        selectPostImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        updatePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatePostInfo();
            }
        });

    }

    private void validatePostInfo() {
        description = postDescription.getText().toString();

        if(imageUri == null){
            Toast.makeText(this, "Please select the image!", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(description)){
            Toast.makeText(this, "Please write something in description...", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("Add New Post");
            loadingBar.setMessage("Please wait, while we are uploading your new post...");
            loadingBar.show();
            loadingBar.setCanceledOnTouchOutside(true);

            storingImage();
        }
    }

    private void storingImage() {
        Calendar calFordDate = Calendar.getInstance();
        SimpleDateFormat currentDate =  new SimpleDateFormat("dd-MMMM-yyyy");
        saveCurrentDate = currentDate.format(calFordDate.getTime());

        Calendar calFordTime = Calendar.getInstance();
        SimpleDateFormat currentTime =  new SimpleDateFormat("HH:mm");
        saveCurrentTime = currentTime.format(calFordTime.getTime());

        postRandomName = saveCurrentDate + saveCurrentTime;

        final StorageReference filePath = postImageReference.child("Post Images").child(imageUri.getLastPathSegment() + postRandomName + ".jpg");

        filePath.putFile(imageUri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if(!task.isSuccessful()){
                    throw task.getException();
                }
                return filePath.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if(task.isSuccessful()){
                    Uri downUri = task.getResult();
                    Toast.makeText(PostActivity.this, "Profile Image stored successfully to Firebase storage...", Toast.LENGTH_SHORT).show();

                    downloadUrl = downUri.toString();
                    savingPost();
                }
                else{
                    String message = task.getException().getMessage();
                    Toast.makeText(PostActivity.this, "Error occured: " + message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void savingPost() {
        usersRef.child(currentUID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String userName = dataSnapshot.child("firstName").getValue().toString();

                    HashMap postsMap = new HashMap();
                    postsMap.put("uid", currentUID);
                    postsMap.put("date", saveCurrentDate);
                    postsMap.put("time", saveCurrentTime);
                    postsMap.put("description", description);
                    postsMap.put("postimage", downloadUrl);
                    postsMap.put("fullname", userName);

                    postRef.child(currentUID + postRandomName).updateChildren(postsMap)
                            .addOnCompleteListener(new OnCompleteListener() {
                                @Override
                                public void onComplete(@NonNull Task task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(PostActivity.this, "New post is updated succesfully", Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(PostActivity.this, "Error occurred while updating your post", Toast.LENGTH_SHORT).show();
                                        loadingBar.dismiss();
                                    }
                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void openGallery() {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, Gallery_Pick);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==Gallery_Pick && resultCode==RESULT_OK && data!=null){
            imageUri = data.getData();
            selectPostImage.setImageURI(imageUri);
        }
    }

}
