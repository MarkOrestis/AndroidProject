package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import team42.cs2340.rattrackingapp.Model.Month;
import team42.cs2340.rattrackingapp.Model.Sighting;
import team42.cs2340.rattrackingapp.R;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

import static android.content.ContentValues.TAG;

/**
 * Page that will filter the data.
 */

public class SearchDateActivity extends Activity {
    private Spinner monthSpinner;
    private Spinner yearSpinner;
    private Spinner monthSpinner2;
    private Spinner yearSpinner2;

    // variables to help with map filtering
    private int startMonth;
    private int startYear;
    private String endMonth;
    private String endYear;

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

    /**
     * Creates the search date page.
     * @param savedInstanceState instance used to create the search date page.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchdate);

        Button search = (Button) findViewById(R.id.confirmsearchdate);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String startmonthString = monthSpinner.getSelectedItem().toString();
                // CONVERTING STRING MONTHS TO INTS HERE:
                switch (startmonthString) {
                    case "January": startMonth = 1;
                        break;
                    case "February": startMonth = 2;
                        break;
                    case "March": startMonth = 3;
                        break;
                    case "April": startMonth = 4;
                        break;
                    case "May": startMonth = 5;
                        break;
                    case "June": startMonth = 6;
                        break;
                    case "July": startMonth = 7;
                        break;
                    case "August": startMonth = 8;
                        break;
                    case "September": startMonth = 9;
                        break;
                    case "October": startMonth = 10;
                        break;
                    case "November": startMonth = 11;
                        break;
                    case "December": startMonth = 12;
                        break;
                }
                startYear = Integer.parseInt(yearSpinner.getSelectedItem().toString());
                String endmonthString = monthSpinner2.getSelectedItem().toString();
                // CONVERTING STRING MONTHS TO INTS HERE:
                switch (endmonthString) {
                    case "January": endMonth = "1";
                        break;
                    case "February": endMonth = "2";
                        break;
                    case "March": endMonth = "3";
                        break;
                    case "April": endMonth = "4";
                        break;
                    case "May": endMonth = "5";
                        break;
                    case "June": endMonth = "6";
                        break;
                    case "July": endMonth = "7";
                        break;
                    case "August": endMonth = "8";
                        break;
                    case "September": endMonth = "9";
                        break;
                    case "October": endMonth = "10";
                        break;
                    case "November": endMonth = "11";
                        break;
                    case "December": endMonth = "12";
                        break;
                }
                endYear = yearSpinner2.getSelectedItem().toString();
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
        for (int i = 2010; i <= thisYear; i++) {
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

    /**
     * Method used to go to the date maps page.
     */
    public void goToDateMaps() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}