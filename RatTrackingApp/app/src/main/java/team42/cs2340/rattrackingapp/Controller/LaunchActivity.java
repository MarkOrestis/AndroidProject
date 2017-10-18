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

        Button dataButton = (Button) findViewById(R.id.dataButton);
        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToData();
            }
        });

        TextView welcomeText = (TextView) findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome " + user + "!");

        Button addRatButton = (Button) findViewById(R.id.ratbutton);
        addRatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddRat();
            }
        });
    }

    public void logOut() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void goToData() {
        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }

    public void goToAddRat() {
        Intent intent = new Intent(this, AddratActivity.class);
        startActivity(intent);
    }

}
