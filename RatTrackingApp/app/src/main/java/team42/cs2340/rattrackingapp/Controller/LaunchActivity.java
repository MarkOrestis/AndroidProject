package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import team42.cs2340.rattrackingapp.R;

/**
 * Created by Orestis Markozanes on 10/2/2017.
 */

public class LaunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Intent intent = getIntent();
        String user = intent.getStringExtra("Username");

        Button logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });

        TextView welcomeText = (TextView) findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome " + user + "!");
    }

    public void logOut() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
