package team42.cs2340.rattrackingapp.Model;

import android.icu.text.SimpleDateFormat;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * SightingList class that gets all the instances of rat sightings form the database.
 */

public class SightingList {

    private DatabaseReference mDatabase;
    private final String TAG = "SightingList";
    private ArrayList<Sighting> sightingList;
    private ArrayList<Sighting> sample;
    private static SightingList instance;

    /**
     * A getInstance method to the all the instances of SightingList.
     */
    public static SightingList getInstance() {
        if (instance == null) {
            instance = new SightingList();
        }
        return instance;
    }

    /**
     * on start-up, gets all the rat data and store it into the phone
     */
    private SightingList() {
        //TODO

        mDatabase = FirebaseDatabase.getInstance().getReference("Sightings");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                //Log.d(TAG, "datasnapshot:" + dataSnapshot.getChildrenCount());

                if (sightingList == null) {
                    sightingList = new ArrayList<Sighting>();
                    int count = 0;
                    while(items.hasNext()) {
                        count++;
                        DataSnapshot item = items.next();
                        String borough, city, createdDate, incidentAddress, incidentZip, latitude,
                                locationType, longitude, uniqueKey;
                        borough = item.child("Borough").getValue().toString();
                        city = item.child("City").getValue().toString();
                        locationType = item.child("Location Type").getValue().toString();
                        createdDate = item.child("Created Date").getValue().toString();
                        incidentAddress = item.child("Incident Address").getValue().toString();
                        incidentZip = item.child("Incident Zip").getValue().toString();
                        latitude = item.child("Latitude").getValue().toString();
                        longitude = item.child("Longitude").getValue().toString();
//                        uniqueKey = item.child("Unique Key").getValue().toString();
                        //Log.d(TAG, "HA:" + date);
//                        String Unique_Key,String Date, String Location_Type,String Incident_Zip,String Incident_Address,
//                                String City,String Borough,String Latitude,String Longitude

                        Sighting entry = new Sighting(createdDate ,locationType, incidentZip,
                                incidentAddress, city, borough, latitude, longitude);
                        sightingList.add(entry);

                        //Log.d(TAG, "ohmygod:" + entry.getDate() +  ", count:" + count);
                    }
                    sample = new ArrayList<Sighting>();
                    for (int i = 0; i < sightingList.size(); i++) {
                        sample.add(sightingList.get(i));
                        String date = sample.get(i).getDate();
                        //Log.d(TAG, "please" + date);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Unable to read in rat data");
            }
        });

    }

    /**
     * GetSightingList that returns the rats in the list.
     * @return the arrayList of sightingArrayList
     */
    public ArrayList<Sighting> getsightingList() {
        return sightingList;
    }

    /**
     * A getSightingListSize the gets the size of the list
     * @return returns the size of the arrayList
     */
    public int getsightingListSize() {
        return sightingList.size();
    }


//    /**
//     * method for searching sightingArrayList by date given a starting date and ending date
//     *
//     * @param start the starting date for the query
//     * @param end the ending date for the query
//     * @return an ArrayList of Sightings that were reported between Date @start and Date @end
//     */
//    public ArrayList<Sighting> sortByDate(Date start, Date end) throws IllegalArgumentException {
//        if (start.compareTo(end) > 0) {
//            throw new IllegalArgumentException("Start date cannot exceed end date.");
//        }
//        ArrayList<Sighting> searchResults = new ArrayList<>();
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//            for (int i = 0; i < 300; i++) {
//                int j = (int) (Math.random() * 100000);
//                Sighting rat = sightingArrayList.get(j);
//                String ratDateText = rat.getDateTime().substring(0, 11);
//                Date ratDate = dateFormat.parse(ratDateText);
//                if (ratDate.compareTo(start) >= 0 && ratDate.compareTo(end) <= 0) {
//                    searchResults.add(rat);
//                }
//            }
//        } catch(Exception e) {
//            System.out.println(e);
//        }
//        return searchResults;
//    }
}