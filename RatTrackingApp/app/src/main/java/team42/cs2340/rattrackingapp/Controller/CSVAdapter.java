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

import team42.cs2340.rattrackingapp.Model.Model;
import team42.cs2340.rattrackingapp.Model.RatSightingData;

/**
 * Created by King Jay on 10/8/2017.
 */

public class CSVAdapter extends ArrayAdapter<RatSightingData> {
    Context csv;
    Model model = Model.getInstance();

    public CSVAdapter(Context context, int textViewResourceID) {
        super(context, textViewResourceID);

        //Store a reference to the context so we can use it to load a file from Model
        addAll(model.getRats());

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

        return mView;
    }
}
