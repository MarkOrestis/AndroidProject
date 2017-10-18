package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import team42.cs2340.rattrackingapp.Model.Admin;
import team42.cs2340.rattrackingapp.Model.Model;
import team42.cs2340.rattrackingapp.Model.Rat;
import team42.cs2340.rattrackingapp.Model.User;
import team42.cs2340.rattrackingapp.R;

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
    CSVFileWriter csv;
    File file;
    StringBuffer filePath;

    private Rat rat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrat);

        uniqueKeyField = (EditText) findViewById(R.id.uniqueKey_text);
        createdDateField = (EditText) findViewById(R.id.createDate_text);
        locationTypeField = (EditText) findViewById(R.id.locationType_text);
        zipField = (EditText) findViewById(R.id.zip_text);
        addressField = (EditText) findViewById(R.id.address_text);
        cityField = (EditText) findViewById(R.id.city_text);
        boroughField = (EditText) findViewById(R.id.borough_text);
        latitudeField = (EditText) findViewById(R.id.latitude_text);
        longitudeField = (EditText) findViewById(R.id.longitude_text);
        Button saveButton = (Button) findViewById(R.id.addratbutton);

        filePath = new StringBuffer();
        filePath.append("/sdcard/abc.csv");
        file = new File(filePath.toString());
        csv = new CSVFileWriter(file);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                csv.writeHeader(uniqueKeyField.getText().toString() + "," +
                        createdDateField.getText().toString() + ",,,,," +
                        locationTypeField.getText().toString()+ "," + zipField.getText().toString()
                        + "," +addressField.getText().toString() + ",,,,,,," +
                        cityField.getText().toString() + ",,,,,,," +
                        boroughField.getText().toString() + ",,,,,,,,,,,,,,,,,,,,,,,,,," +
                        latitudeField.getText().toString() + "," +
                        longitudeField.getText().toString() + ",,");
                returnToDataScreen();
            }

        });

    }

    public void returnToDataScreen() {
        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }
}
