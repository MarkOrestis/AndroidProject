package team42.cs2340.rattrackingapp.Controller;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.util.ArrayList;

import team42.cs2340.rattrackingapp.R;

/**
 * Page that displays all the data in a list view.
 */

public class DataActivity extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;
    private ListView sightingList;
    private ArrayList<String> sightings = new ArrayList<>();
    private static final String TAG = "DataActivity";

    /**
     * Creates the list view page using the activity_data xml file.
     * @param savedInstanceState the instance that will be used for this page
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        mDatabase = FirebaseDatabase.getInstance().getReference("Sightings");
        sightingList = (ListView) findViewById(R.id.mList);

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

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, sightings);
        sightingList.setAdapter(arrayAdapter);
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
                Log.d(TAG, "Datasnapshot:" + dataSnapshot.getChildrenCount());

                sightings.add(key);
                arrayAdapter.notifyDataSetChanged();
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

        sightingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                String string = arrayAdapter.getItem(pos);
                Log.d(TAG, "TESTING:" + string);

                Intent intent = new Intent(DataActivity.this, DetailActivity.class);
                intent.putExtra("Detail", string);
                startActivity(intent);
            }
        });
    }
}
