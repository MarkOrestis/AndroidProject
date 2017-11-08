package team42.cs2340.rattrackingapp.Controller;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import team42.cs2340.rattrackingapp.Model.Sighting;
import team42.cs2340.rattrackingapp.R;

/**
 * A page that displays the specific details of a rat sighting data
 */
public class DetailActivity extends AppCompatActivity {

    private Sighting sighting = new Sighting();
    private DatabaseReference mDatabase;
    private String sightingKey;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "DetailActivity";

    /**
     * Creates a page that has the specific details of a rat sighting.
     * @param savedInstanceState the instance that will be used for this page.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        sightingKey = getIntent().getStringExtra("Detail");
        Log.d(TAG,"TEST:" + sightingKey);
        mDatabase = FirebaseDatabase.getInstance().getReference("Sightings").child(sightingKey);

        mDatabase.addChildEventListener(new ChildEventListener() {
            /**
             * One of the five methods that runs through when a child is added to check data inside
             * the fire base database.
             * @param dataSnapshot the snapshot of the data currently in the database
             * @param s a string that will hold some data
             */
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String key = dataSnapshot.getKey();

                Log.d(TAG, "Children:" + dataSnapshot.getChildrenCount());


                if (key.equals("City")) {
                    String value = (String) dataSnapshot.getValue();
                    sighting.setCity(value);
                    Log.d(TAG, "City: " + sighting.getCity().toString());
                }
                if (key.equals("Created Date")) {
                    String value = (String) dataSnapshot.getValue();
                    sighting.setDate(value);
                }
                if (key.equals("Location Type")) {
                    String value = (String) dataSnapshot.getValue();
                    sighting.setLocationType(value);
                }
                if (key.equals("Incident Zip")) {
                    Log.d(TAG, "Zip:" + dataSnapshot.getValue().getClass());
                    String value = Long.toString((Long) dataSnapshot.getValue());
                    sighting.setIncidentZip(value);
                }
                if (key.equals("Incident Address")) {
                    String value = (String) dataSnapshot.getValue();
                    sighting.setIncidentAddress(value);
                }
                  if (key.equals("Borough")) {
                    Log.d(TAG, "Borough:" + dataSnapshot.getValue().getClass());
                      String value = (String) dataSnapshot.getValue();
                      sighting.setBorough(value);
                  }
                if (key.equals("Latitude")) {
                    Log.d(TAG, "Latitude:" + dataSnapshot.getValue().getClass());
                    String value = String.valueOf(dataSnapshot.getValue());
                    sighting.setLatitude(value);
                }
                if (key.equals("Longitude")) {
                    Log.d(TAG, "Longitude:" + dataSnapshot.getValue().getClass());

                    String value = Double.toString((Double) dataSnapshot.getValue());
                    sighting.setLongitude(value);
                }
                TextView tv = ((TextView) findViewById(R.id.ratDetail));
                //tv.setText(sighting.getCity());
                tv.setText("Created Date: " + sighting.getDate() + "\n"
                        +"Location Type: " + sighting.getLocationType() + "\n"
                        +"Incident Zip: " + sighting.getIncidentZip() + "\n"
                        +"Incident Address: " + sighting.getIncidentAddress() + "\n"
                        +"City: " + sighting.getCity() + "\n"
                        +"Borough: " + sighting.getBorough() + "\n"
                        +"Latitude: " + sighting.getLatitude() + "\n"
                        +"Longitude: " + sighting.getLongitude());


            }
            /**
             * One of the five methods that runs through when a child is changed to check data inside
             * the fire base database.
             * @param dataSnapshot the snapshot of the data currently in the database
             * @param s a string that will hold some data
             */
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            /**
             * One of the five methods that runs through when a child is removed to check data inside
             * the fire base database.
             * @param dataSnapshot the snapshot of the data currently in the database
             */
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            /**
             * One of the five methods that runs through when a child is moved to check data inside
             * the fire base database.
             * @param dataSnapshot the snapshot of the data currently in the database
             * @param s a string that will hold some data
             */
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            /**
             * One of the five methods that runs through to see what happens when
             * database reading is cancelled.
             * @param databaseError a parameter that holds an error in the database
             */
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
