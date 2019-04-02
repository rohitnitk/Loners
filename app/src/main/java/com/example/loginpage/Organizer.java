package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Organizer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public TextView profile,creevnt,activity,cmnts;
    public ImageView prfl,cevnt,actvy,cmnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_navigation);
        prfl= (ImageView) findViewById(R.id.ivprfl);
        cevnt= (ImageView) findViewById(R.id.ivevnt);
        //actvy=(ImageView) findViewById(R.id.ivacty);
        //cmnt=(ImageView) findViewById(R.id.ivcmnt);
        profile=(TextView)findViewById(R.id.tvpfl);
        creevnt=(TextView)findViewById(R.id.tvent);
        activity=(TextView)findViewById(R.id.tvacty);
        cmnts=(TextView)findViewById(R.id.tvcmnt);


        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.about) {

        } else if (id == R.id.contact) {

        } else if (id == R.id.terms) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void createEvent(View view) {
        Intent intent= new Intent(Organizer.this,Events.class);
        startActivity(intent);
    }

    public void messenger1(View view) {
        Intent intent= new Intent(Organizer.this,chatlogin.class);
        startActivity(intent);
    }



    public void activity(View view) {
       Intent intent= new Intent(Organizer.this,history.class);
      startActivity(intent);
  }


    public void OrgProfile(View view)
    {
        Intent i = new Intent(this, OrgProfile.class);
        startActivity(i);
    }

    public void home(View view) {
        Intent intent= new Intent(Organizer.this,Home.class);
        startActivity(intent);
    }
    public void delete(View view){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Organizer.this, "your account has been deleted", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });

    }
}


