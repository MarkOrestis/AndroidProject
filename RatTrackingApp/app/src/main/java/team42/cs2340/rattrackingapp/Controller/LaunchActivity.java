package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import team42.cs2340.rattrackingapp.Model.RatSightingData;
import team42.cs2340.rattrackingapp.R;
import team42.cs2340.rattrackingapp.Model.Model;

/**
 * Created by Orestis Markozanes on 10/2/2017.
 */

public class LaunchActivity extends Activity {
    Model model = Model.getInstance();

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

        Button viewMapsButton = (Button) findViewById(R.id.mapbutton);
        viewMapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMaps();
            }
        });

        try {
            //Get input stream and Buffered Reader for our data file.
            InputStream is = getApplicationContext().getAssets().open("RatSighting.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            //Read each line
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");

                //Create a RatSighting object for each row data.
                RatSightingData cur = new RatSightingData(rowData[0], rowData[1], rowData[7],
                        rowData[8], rowData[9], rowData[16], rowData[23], rowData[49], rowData[50]);
                //Add the RatSightingData object to the ArrayList
                model.addRat(cur);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void goToMaps() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}
