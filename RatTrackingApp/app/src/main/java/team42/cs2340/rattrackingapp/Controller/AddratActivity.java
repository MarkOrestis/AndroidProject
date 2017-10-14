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

        file = new File("RatSighting.csv");
        csv = new CSVFileWriter(file);

        cityField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.addratbutton || id == EditorInfo.IME_NULL) {
                    register();
                    return true;
                }
                return false;
            }
        });
        Button mRegisterButton = (Button) findViewById(R.id.addratbutton);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        Button cancelButton = (Button) findViewById(R.id.canceladdratbutton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToDataScreen();
            }
        });
    }

    public void returnToDataScreen() {
        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }

    public void register() {
        Model model = Model.getInstance();
        String city = cityField.getText().toString();

        boolean found = false;

        int x = 0;

        while (x < model.getRats().size()) {
            if (model.getRats().get(x).getUniqueKey().equals(city)) {
                found = true;
            }
            x++;
        }
        if (!found) {
            model.addRat(rat);
            Intent intent = new Intent(this, DataActivity.class);
            startActivity(intent);
        }

        if (found) {
            Toast.makeText(this, "Rat already exists.", Toast.LENGTH_SHORT).show();
        }
    }
}
