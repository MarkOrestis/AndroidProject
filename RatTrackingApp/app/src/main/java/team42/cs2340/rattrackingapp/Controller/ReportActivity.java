package team42.cs2340.rattrackingapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import team42.cs2340.rattrackingapp.Model.Sighting;
import team42.cs2340.rattrackingapp.R;

/**
 * Created by Orestis Markozanes on 10/28/2017.
 */

public class ReportActivity extends AppCompatActivity {

    private Sighting sighting = new Sighting();
    private DatabaseReference mDatabase;
    private Button addRat;
    private EditText createdDateField;
    private EditText locationTypeField;
    private EditText zipField;
    private EditText addressField;
    private EditText cityField;
    // private EditText boroughField;
    private EditText latitudeField;
    private EditText longitudeField;
    private static final String TAG = "ReportActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        cityField = (EditText) findViewById(R.id.city_text);
        mDatabase = FirebaseDatabase.getInstance().getReference();



        addRat = (Button) findViewById(R.id.addratbutton);
        addRat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRat();
            }
        });
    }
    public void addRat() {
        cityField.setError(null);
        //passwordField.setError(null);

        final String city = cityField.getText().toString();
        //String password = passwordField.getText().toString().trim();

        sighting.setCity(city);
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String childrenCount = Long.toString(dataSnapshot.getChildrenCount());
                DatabaseReference sightings = mDatabase.child(childrenCount);
                String key = dataSnapshot.getKey();

                //sighting.getCity() = city input

                //Log.d(TAG, "Datasnapshot:" + );
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}