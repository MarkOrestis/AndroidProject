package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import team42.cs2340.rattrackingapp.Model.Admin;
import team42.cs2340.rattrackingapp.Model.Borough;
import team42.cs2340.rattrackingapp.Model.LocationType;
import team42.cs2340.rattrackingapp.Model.Model;
import team42.cs2340.rattrackingapp.Model.Rat;
import team42.cs2340.rattrackingapp.Model.RatSightingData;
import team42.cs2340.rattrackingapp.Model.User;
import team42.cs2340.rattrackingapp.R;
import android.content.Context;

import java.io.File;

/**
 * Created by Beatrice on 10/14/17.
 */

public class AddratActivity extends Activity {
    private EditText uniqueKeyField;
    private EditText createdDateField;
    private EditText locationTypeField;
    private EditText zipField;
    private EditText addressField;
    private EditText cityField;
    private EditText boroughField;
    private EditText latitudeField;
    private EditText longitudeField;


    private Spinner locationTypeSpinner;
    private Spinner boroughSpinner;

    CSVFileWriter csv;
    File file;
    StringBuffer filePath;
    Model model = Model.getInstance();
    RatSightingData ratatat;

    private Rat rat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrat);

        uniqueKeyField = (EditText) findViewById(R.id.uniqueKey_text);
        createdDateField = (EditText) findViewById(R.id.createDate_text);
        //locationTypeField = (EditText) findViewById(R.id.locationType_text);
        locationTypeSpinner = (Spinner) findViewById(R.id.locationType_Spinner);
        zipField = (EditText) findViewById(R.id.zip_text);
        addressField = (EditText) findViewById(R.id.address_text);
        cityField = (EditText) findViewById(R.id.city_text);
        boroughSpinner = (Spinner) findViewById(R.id.borough_Spinner);
        latitudeField = (EditText) findViewById(R.id.latitude_text);
        longitudeField = (EditText) findViewById(R.id.longitude_text);
        Button saveButton = (Button) findViewById(R.id.addratbutton);

        /*
         * Set up adapter to display the allowable location types in the spinner
         */
        ArrayAdapter<String> locationType_adapter = new ArrayAdapter(this, R.layout.spinner_item, LocationType.values());
        locationType_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationTypeSpinner.setAdapter(locationType_adapter);


        /*
         * Set up adapter to display the allowable boroughs in the spinner
         */
        ArrayAdapter<String> borough_adapter = new ArrayAdapter(this, R.layout.spinner_item, Borough.values());
        borough_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boroughSpinner.setAdapter(borough_adapter);

        filePath = new StringBuffer();
        filePath.append("/res/raw/rat_sighting.csv");
        file = new File(filePath.toString());
        android.util.Log.v("Filepath", file.getAbsolutePath());
        csv = new CSVFileWriter(file);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ratatat = new RatSightingData(uniqueKeyField.getText().toString(),
                        createdDateField.getText().toString(),
                        locationTypeField.getText().toString(),zipField.getText().toString(),
                        addressField.getText().toString(), cityField.getText().toString(),
                        boroughField.getText().toString(), latitudeField.getText().toString(),
                        longitudeField.getText().toString());
                model.addRat(ratatat);
                returnToDataScreen();
            }

        });

    }

    public void returnToDataScreen() {
        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }
}
