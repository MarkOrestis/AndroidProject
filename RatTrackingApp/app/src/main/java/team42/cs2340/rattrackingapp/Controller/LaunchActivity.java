package team42.cs2340.rattrackingapp.Controller;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import team42.cs2340.rattrackingapp.Model.Sighting;
import team42.cs2340.rattrackingapp.Model.SightingList;
import team42.cs2340.rattrackingapp.R;

/**
 * Page that will display after the user login is successful and has all the buttons
 * that the user will select to view the desired page.
 */

public class LaunchActivity extends AppCompatActivity {

    private Button logOut;
    private Button viewData;
    private Button addRat;
    private Button searchData;
    private Button viewMaps;
    private FirebaseAuth mAuth;
    ArrayList<Sighting> sightingArrayList;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "LaunchActivity";

    @Override

    /**
     * Creates the launch page with all the necessary buttons
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        SightingList sightingList = SightingList.getInstance();
        sightingArrayList = sightingList.getsightingList();
//        Log.d(TAG, "hehe" + sightingArrayList.get(18).getCity());


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        logOut = (Button) findViewById(R.id.logoutButton);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(LaunchActivity.this, WelcomeActivity.class));
            }
        });

        viewData = (Button) findViewById(R.id.dataButton);
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchActivity.this, DataActivity.class));
            }
        });

        addRat = (Button) findViewById(R.id.ratbutton);
        addRat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchActivity.this, ReportActivity.class));
            }
        });

        searchData = (Button) findViewById(R.id.searchButton);
        searchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LaunchActivity.this, SearchDataActivity.class));
            }
        });

        viewMaps = (Button) findViewById(R.id.mapbutton);
        viewMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LaunchActivity.this, MapsActivity.class));
            }
        });
    }
}
