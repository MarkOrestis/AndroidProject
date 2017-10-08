package team42.cs2340.rattrackingapp.Controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
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
        this.csv = context;

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
                cur.setIncidentZip(rowData[8]);
                cur.setIncidentAddress(rowData[9]);
                cur.setCity(rowData[16]);
                cur.setBorough(rowData[23]);
                cur.setLatitude(rowData[49]);
                cur.setLongitude(rowData[50]);

                //Add the RatSightingData object to the ArrayList
                this.add(cur);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View getView(final int pos, View convertView, final ViewGroup parent) {

        TextView mView = (TextView)convertView;
        if (null == mView) {
            mView = new TextView(parent.getContext());
            mView.setTextSize(28);
        }

        //Set the unique key as the text
        mView.setText(getItem(pos).getUniqueKey());
        System.out.println("HuEY");

        return mView;
    }
}
