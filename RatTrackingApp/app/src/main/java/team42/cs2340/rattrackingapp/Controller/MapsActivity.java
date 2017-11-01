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
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
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

import static android.content.ContentValues.TAG;

/**
 * Created by Beatrice on 10/30/17.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
                elDate.add(dataSnapshot.child("Created Date").getValue().toString());
                double lat = Double.parseDouble(dataSnapshot.child("Latitude").getValue().toString());
                double lon = Double.parseDouble(dataSnapshot.child("Longitude").getValue().toString());
//                String date = dataSnapshot.child()
                for (String datey : elDate) {
                    if(dataSnapshot.child("Created Date").getValue().toString().equals("9/4/2015 0:00")) {
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

    }

    public void filter(String monthStart, String monthEnd, String yearStart, String yearEnd) {
        if (monthStart.equals("January")) {
            monthStart = "1";
        } else if (monthStart.equals("February")) {
            monthStart = "2";
        }   else if (monthStart.equals("March")) {
            monthStart = "3";
        }   else if (monthStart.equals("April")) {
            monthStart = "4";
        }   else if (monthStart.equals("May")) {
            monthStart = "5";
        }   else if (monthStart.equals("June")) {
            monthStart = "6";
        }   else if (monthStart.equals("July")) {
            monthStart = "7";
        }   else if (monthStart.equals("August")) {
            monthStart = "8";
        }   else if (monthStart.equals("September")) {
            monthStart = "9";
        }   else if (monthStart.equals("October")) {
            monthStart = "10";
        }   else if (monthStart.equals("November")) {
            monthStart = "11";
        }   else if (monthStart.equals("December")) {
            monthStart = "12";
        }
        if (monthEnd.equals("January")) {
            monthEnd = "1";
        } else if (monthEnd.equals("February")) {
            monthEnd = "2";
        }   else if (monthEnd.equals("March")) {
            monthEnd = "3";
        }   else if (monthEnd.equals("April")) {
            monthEnd = "4";
        }   else if (monthEnd.equals("May")) {
            monthEnd = "5";
        }   else if (monthEnd.equals("June")) {
            monthEnd = "6";
        }   else if (monthEnd.equals("July")) {
            monthEnd = "7";
        }   else if (monthEnd.equals("August")) {
            monthEnd = "8";
        }   else if (monthEnd.equals("September")) {
            monthEnd = "9";
        }   else if (monthEnd.equals("October")) {
            monthEnd = "10";
        }   else if (monthEnd.equals("November")) {
            monthEnd = "11";
        }   else if (monthEnd.equals("December")) {
            monthEnd = "12";
        }
        final int startMonth = Integer.parseInt(monthStart);
        final int endMonth = Integer.parseInt(monthEnd);
        final int startYear = Integer.parseInt(yearStart);
        final int endYear = Integer.parseInt(yearEnd);

        before = new Date(startYear, startMonth, 1);
        after = new Date(endYear, endMonth, 1);
        mDatabase = FirebaseDatabase.getInstance().getReference("Sightings");
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mDatabase.child(dataSnapshot.getKey());
                String key = dataSnapshot.getKey();
                String date = (String) dataSnapshot.child("Created Date").getValue();
                String lattitude = "" + dataSnapshot.child("Latitude").getValue();
                String longitude = "" + dataSnapshot.child("Longitude").getValue();
                sightingArray.add(new Sighting(key, date, lattitude, longitude));
                Log.d(TAG,"checking" + sightingArray.toString());
                for (int i = 0; i < sightingArray.size(); i++) {
                    String getDate = sightingArray.get(i).getDate();
                    String[] dataArray = getDate.split("/");
                    int month = Integer.parseInt(dataArray[0]);
                    int day = Integer.parseInt(dataArray[1]);
                    int year = Integer.parseInt(dataArray[2].substring(0,4));
                    check = new Date(year, month, day);
                    if (before.before(check) && after.after(check)) {
                        filtered.add(sightingArray.get(i));
                    }
                    Log.d("chosenDateRange", "" + startMonth + "-" + endMonth + "/"+ startYear + "-" + endYear);
                    Log.d("dateCheck", + month + "---" + year);
                }
                Log.d(TAG, "filtered" + filtered.toString());
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
        //sightingArray.add(new Sighting("1", "9/4/2015"));
        //Log.d(TAG,"sightings" + sightingArray.toString());
        //Log.d(TAG, "sightings" + sightingArray.toString());

        //Log.d(TAG, "filtered" + filtered.toString());
        //return filtered;
    }

}
