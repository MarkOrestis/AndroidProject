package team42.cs2340.rattrackingapp.Controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import team42.cs2340.rattrackingapp.Model.Month;
import team42.cs2340.rattrackingapp.Model.Sighting;
import team42.cs2340.rattrackingapp.R;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.model.Marker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import static android.content.ContentValues.TAG;

/**
 * Created by Beatrice on 10/30/17.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private Spinner monthSpinner;
    private Spinner yearSpinner;
    private Spinner monthSpinner2;
    private Spinner yearSpinner2;

    // variables to help with map filtering
    // USE THESE VARIABLES, J! :)
    // YAY.
    private int startMonth;
    private int startYear;
    private String endMonth;
    private String endYear;

    private GoogleMap mMap;
    private DatabaseReference mDatabase;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "MapsActivity";
    private ArrayList<Sighting> filtered = new ArrayList<>();
    private ArrayList<Sighting> sightingArray = new ArrayList<>();
    List<String> elDate = new ArrayList<>();
    Date before;
    Date after;
    Date check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//        String adder = "";
//        do {
//            Log.d("BEATRICE", "HEY" + startMonth + startYear);
//            adder = "" + startMonth + startYear;
//            elDate.add(adder);
//            if(startMonth != 12) {
//                startMonth++;
//            } else {
//                startMonth = 1;
//                startYear++;
//            }
//        } while(!adder.equals(endMonth + endYear));
        mDatabase = FirebaseDatabase.getInstance().getReference("Sightings");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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

        Button search = (Button) findViewById(R.id.confirmsearchdate);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String startmonthString = monthSpinner.getSelectedItem().toString();
                // CONVERTING STRING MONTHS TO INTS HERE:
                switch (startmonthString) {
                    case "January": startMonth = 1;
                        break;
                    case "February": startMonth = 2;
                        break;
                    case "March": startMonth = 3;
                        break;
                    case "April": startMonth = 4;
                        break;
                    case "May": startMonth = 5;
                        break;
                    case "June": startMonth = 6;
                        break;
                    case "July": startMonth = 7;
                        break;
                    case "August": startMonth = 8;
                        break;
                    case "September": startMonth = 9;
                        break;
                    case "October": startMonth = 10;
                        break;
                    case "November": startMonth = 11;
                        break;
                    case "December": startMonth = 12;
                        break;
                }
                startYear = Integer.parseInt(yearSpinner.getSelectedItem().toString());
                String endmonthString = monthSpinner2.getSelectedItem().toString();
                // CONVERTING STRING MONTHS TO INTS HERE:
                switch (endmonthString) {
                    case "January": endMonth = "1";
                        break;
                    case "February": endMonth = "2";
                        break;
                    case "March": endMonth = "3";
                        break;
                    case "April": endMonth = "4";
                        break;
                    case "May": endMonth = "5";
                        break;
                    case "June": endMonth = "6";
                        break;
                    case "July": endMonth = "7";
                        break;
                    case "August": endMonth = "8";
                        break;
                    case "September": endMonth = "9";
                        break;
                    case "October": endMonth = "10";
                        break;
                    case "November": endMonth = "11";
                        break;
                    case "December": endMonth = "12";
                        break;
                }
                endYear = yearSpinner2.getSelectedItem().toString();
            }
        });

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in nyc, Australia, and move the camera.
        final LatLng nyc = new LatLng(40.7128, -74.0060);
//        mMap.addMarker(new MarkerOptions().position(nyc).title("Marker in nyc"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nyc));
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("TESTING", "HEY" + dataSnapshot.child("Created Date").getValue().toString());
                StringTokenizer butt = new StringTokenizer(dataSnapshot.child("Created Date").getValue().toString(), "/");
                String first = butt.nextToken();
                String second = butt.nextToken();
                String third = butt.nextToken().substring(0,4);
                Log.d("TESTING", "HEY" + first + third);
                String time = first + third;
                elDate.add("92015");
                double lat = Double.parseDouble(dataSnapshot.child("Latitude").getValue().toString());
                double lon = Double.parseDouble(dataSnapshot.child("Longitude").getValue().toString());
//                String date = dataSnapshot.child()/
                for (String datey : elDate) {
                    if((dataSnapshot.child("Created Date").getValue().toString().substring(0,1)
                            + dataSnapshot.child("Created Date").getValue().toString().substring(4,8)).equals(datey)) {
                        LatLng mark = new LatLng(lat, lon);
                        String key = dataSnapshot.child("Unique Key").getValue().toString();
                        mMap.addMarker(new MarkerOptions().position(mark).title(key));
                    }
                }


//                LatLng mark = new LatLng(lat, lon);
//                String key = dataSnapshot.child("Unique Key").getValue().toString();
//                mMap.addMarker(new MarkerOptions().position(mark).title(key));
//                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
//                    String name = (String) messageSnapshot.child(messageSnapshot.getKey()).getValue();
//                    Log.d("TESTING", "HEY" + name);
//                }
//                elSightings.add(dataSnapshot.getValue(Sighting.class));
//                for (Sighting sights: elSightings) {
//                    LatLng mark = new LatLng(Double.parseDouble(sights.getLatitude())
//                    , -(Double.parseDouble(sights.getLongitude())));
//                    mMap.addMarker(new MarkerOptions().position(mark).title(sights.getDate()));
//                }
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

        monthSpinner = (Spinner) findViewById(R.id.searchmonth_Spinner);
        yearSpinner = (Spinner) findViewById(R.id.searchyear_Spinner);
        monthSpinner2 = (Spinner) findViewById(R.id.searchmonth_Spinner2);
        yearSpinner2 = (Spinner) findViewById(R.id.searchyear_Spinner2);


    /*
     * Set up adapter to display the allowable months in the spinner
     */
        ArrayAdapter<String> month_adapter = new ArrayAdapter(this, R.layout.spinner_item, Month.values());
        month_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(month_adapter);

    /*
     * Set up adapter to display the allowable years in the spinner
     */
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2010; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> year_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, years);
        year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(year_adapter);

    /*
     * Set up adapter to display the allowable months in the spinner
     */
        ArrayAdapter<String> month_adapter2 = new ArrayAdapter(this, R.layout.spinner_item, Month.values());
        month_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner2.setAdapter(month_adapter2);

    /*
     * Set up adapter to display the allowable years in the spinner
     */
        ArrayAdapter<String> year_adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item, years);
        year_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner2.setAdapter(year_adapter2);

    }

}
