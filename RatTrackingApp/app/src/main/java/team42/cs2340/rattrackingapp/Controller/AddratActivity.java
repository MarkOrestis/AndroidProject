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
    private EditText cityField;
    CSVFileWriter csv;
    File file;

    private Rat rat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrat);

        cityField = (EditText) findViewById(R.id.city_text);
        Button saveButton = (Button) findViewById(R.id.addratbutton);
        file = new File("RatSighting.csv");
        csv = new CSVFileWriter(file);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                csv.writeHeader(cityField.getText().toString());

            }
        });

    }

    public void returnToDataScreen() {
        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }
}
