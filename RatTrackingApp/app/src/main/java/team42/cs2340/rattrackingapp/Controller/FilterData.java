package team42.cs2340.rattrackingapp.Controller;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

import team42.cs2340.rattrackingapp.Model.Sighting;
import team42.cs2340.rattrackingapp.R;

import static android.content.ContentValues.TAG;

/**
 * Created by saniya on 10/30/2017.
 */

public class FilterData  {
    private DatabaseReference mDatabase;
    private ArrayList<Sighting> filtered = new ArrayList<>();
    private ArrayList<Sighting> sightingArray = new ArrayList<>();
    Date before;
    Date after;
    Date check;

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
