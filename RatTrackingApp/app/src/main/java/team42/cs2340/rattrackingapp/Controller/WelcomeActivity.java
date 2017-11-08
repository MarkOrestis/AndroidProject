package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import team42.cs2340.rattrackingapp.Model.Sighting;
import team42.cs2340.rattrackingapp.R;

/**
 * The first activity page that is launched when the user first opens the application.
 */

public class WelcomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "WelcomeActivity";

    /**
     * Creates the welcome activity page.
     * @param savedInstanceState the instance used to create the welcome page.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //reading csv
        InputStream inputStream = getResources().openRawResource(R.raw.tinyratsighting);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    startActivity(new Intent(WelcomeActivity.this, LaunchActivity.class));
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
                Log.d(TAG, "Inside mAuthListener");
            }

        };

        Button loginButton = (Button) findViewById(R.id.loginbtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginScreen();
            }
        });
        Button mRegisterButton = (Button) findViewById(R.id.registerbtn);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegisterScreen();
            }
        });
    }

    /**
     * A click listener method that brings the user from the Welcome Activity page to the Login
     * screen.
     */
    public void goToLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * A click listener method that bring the user from the Welcome Activity page to the register
     * screen.
     */
    public void goToRegisterScreen() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * Method used to listen to the database.
     */
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    /**
     * Method used to stop listening to the database.
     */
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
