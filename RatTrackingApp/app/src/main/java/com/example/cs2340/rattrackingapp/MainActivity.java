package com.example.cs2340.rattrackingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.orest.rattrackingapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button logIn = (Button) findViewById(R.id.button);
        logIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //code should execute here
            }

            });

        final Button register = (Button) findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //code should execute here
            }

        });
    }

}
