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
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import team42.cs2340.rattrackingapp.Model.Borough;
import team42.cs2340.rattrackingapp.Model.LocationType;
import team42.cs2340.rattrackingapp.Model.Sighting;
import team42.cs2340.rattrackingapp.Model.SightingList;
import team42.cs2340.rattrackingapp.R;

/**
 * Created by Orestis Markozanes on 10/28/2017.
 */

public class ReportActivity extends AppCompatActivity {

    private Sighting sighting = new Sighting();
    private DatabaseReference mDatabase;
    private Button addRat;
    private EditText createdDateField;
    private Spinner locationTypeSpinner;
    private EditText zipField;
    private EditText addressField;
    private EditText cityField;
    private Spinner boroughSpinner;
    private EditText latitudeField;
    private EditText longitudeField;
    SightingList sightingList;
    ArrayList<Sighting> sightingArrayList;
    private static final String TAG = "ReportActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        sightingList = SightingList.getInstance();
        sightingArrayList = sightingList.getsightingList();

        cityField = (EditText) findViewById(R.id.city_text);
        createdDateField = (EditText) findViewById(R.id.createDate_text);
        addressField = (EditText) findViewById(R.id.address_text);
        latitudeField = (EditText) findViewById(R.id.latitude_text);
        longitudeField = (EditText) findViewById(R.id.longitude_text);
        zipField = (EditText) findViewById(R.id.zip_text);
        locationTypeSpinner = (Spinner) findViewById(R.id.locationType_Spinner);
        boroughSpinner = (Spinner) findViewById(R.id.borough_Spinner);
        //boroughField = (EditText) findViewById(R.id.borough_Spinner);

        /*
         * Set up adapter to display the allowable location types in the spinner
         */
        ArrayAdapter<String> locationType_adapter = new ArrayAdapter(this, R.layout.spinner_item, LocationType.values());
        locationType_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationTypeSpinner.setAdapter(locationType_adapter);

        /*
         * Set up adapter to display the allowable boroughs in the spinner
         */
        ArrayAdapter<String> borough_adapter = new ArrayAdapter(this, R.layout.spinner_item, Borough.values());
        borough_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boroughSpinner.setAdapter(borough_adapter);


        mDatabase = FirebaseDatabase.getInstance().getReference();



        addRat = (Button) findViewById(R.id.addratbutton);
        addRat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRat();
                startActivity(new Intent(ReportActivity.this, LaunchActivity.class));
            }
        });
    }
    public void addRat() {
        cityField.setError(null);
        //passwordField.setError(null);

        final String date = createdDateField.getText().toString();
        final String city = cityField.getText().toString();
        final String address = addressField.getText().toString();
        final String latitude = latitudeField.getText().toString();
        final String longitude = longitudeField.getText().toString();
        final String zip = zipField.getText().toString();
        final String loctype = locationTypeSpinner.getSelectedItem().toString();
        final String borough = boroughSpinner.getSelectedItem().toString();
        final Long zip2 = Long.parseLong(zip);
        final Double latitude2 = Double.parseDouble(latitude);
        final Double longitude2 = Double.parseDouble(longitude);

        //String password = passwordField.getText().toString().trim();
        sightingArrayList.add(new Sighting(date, loctype, zip, address, city, borough, latitude,
                longitude));

        sighting.setCity(city);
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String childrenCount = Long.toString(dataSnapshot.getChildrenCount());
                mDatabase.child("Sightings").child(childrenCount).child("Created Date").setValue(date);
                mDatabase.child("Sightings").child(childrenCount).child("City").setValue(city);
                mDatabase.child("Sightings").child(childrenCount).child("Incident Address").setValue(address);
                mDatabase.child("Sightings").child(childrenCount).child("Incident Zip").setValue(zip2);
                mDatabase.child("Sightings").child(childrenCount).child("Location Type").setValue(loctype);
                mDatabase.child("Sightings").child(childrenCount).child("Borough").setValue(borough);
                Log.d(TAG, latitude2.getClass().toString());
                mDatabase.child("Sightings").child(childrenCount).child("Latitude").setValue(latitude2);
                mDatabase.child("Sightings").child(childrenCount).child("Longitude").setValue(longitude2);
                String key = dataSnapshot.getKey();

                //sighting.getCity() = city input

                Log.d(TAG, "Datasnapshot:" + dataSnapshot.getChildrenCount() );
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
