package team42.cs2340.rattrackingapp.Controller;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import team42.cs2340.rattrackingapp.Model.RatSightingData;

/**
 * Created by King Jay on 10/8/2017.
 */

public class CSVAdapter extends ArrayAdapter<RatSightingData> {
    Context csv;

    public CSVAdapter(Context context, int textViewResourceID) {
        super(context, textViewResourceID);

        //Store a reference to the context so we can use it to load a file from Model
        this.csv = csv;

        //Load the data
        loadArrayFromFile();
    }


    private void loadArrayFromFile() {
        try {
            //Get input stream and Buffered Reader for our data file.
            InputStream is = csv.getAssets().open("RatSighting.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            //Read each line
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");

                //Create a RatSighting object for each row data.
                RatSightingData cur = new RatSightingData();
                cur.setUniqueKey(rowData[0]);
                cur.setCreatedDate(rowData[1]);
                cur.setLocationType(rowData[7]);
                cur.setIncidentZip(rowData[])

//                Unique Key
//                Created Date
//                Location Type
//                Incident Zip
//                Incident Address
//                City
//                        Borough
//                Latitude
//                        Longitude

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
