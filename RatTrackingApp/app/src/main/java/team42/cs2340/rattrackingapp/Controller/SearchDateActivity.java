package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

import static android.content.ContentValues.TAG;

/**
 * Created by Beatrice on 10/30/17.
 */

public class SearchDateActivity extends Activity {
    private Spinner monthSpinner;
    private Spinner yearSpinner;
    private Spinner monthSpinner2;
    private Spinner yearSpinner2;

    public Spinner getMonthSpinner() {
        return monthSpinner;
    }
    public Spinner getYearSpinner() {
        return yearSpinner;
    }
    public  Spinner getMonthSpinner2() {
        return monthSpinner2;
    }
    public Spinner getYearSpinner2() {
        return yearSpinner2;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchdate);

        Button search = (Button) findViewById(R.id.confirmsearchdate);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monthStart = monthSpinner.getSelectedItem().toString();
                String yearStart = yearSpinner.getSelectedItem().toString();
                String monthEnd = monthSpinner2.getSelectedItem().toString();
                String yearEnd = yearSpinner2.getSelectedItem().toString();
                FilterData filterdata = new FilterData();
                filterdata.filter(monthStart, monthEnd, yearStart, yearEnd);
                goToDateMaps();
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
        for (int i = 2015; i <= thisYear; i++) {
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

    public void goToDateMaps() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}