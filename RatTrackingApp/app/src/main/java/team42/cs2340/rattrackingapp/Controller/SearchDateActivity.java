package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import team42.cs2340.rattrackingapp.Model.Month;
import team42.cs2340.rattrackingapp.R;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Beatrice on 10/27/17.
 */

public class SearchDateActivity extends Activity {
    private Spinner monthSpinner;
    private Spinner yearSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchdate);

        monthSpinner = (Spinner) findViewById(R.id.searchmonth_Spinner);
        yearSpinner = (Spinner) findViewById(R.id.searchyear_Spinner);

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
        for (int i = 1950; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> year_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, years);
        year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(year_adapter);
    }

}
