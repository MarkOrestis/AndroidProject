package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import team42.cs2340.rattrackingapp.R;

/**
 * Created by Beatrice on 10/27/17.
 */

public class SearchDataActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchdata);

        Button searchByDateButton = (Button) findViewById(R.id.searchdatebtn);
        searchByDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSearchDateScreen();
            }
        });
    }

    public void goToSearchDateScreen() {
        Intent intent = new Intent(this, SearchDateActivity.class);
        startActivity(intent);
    }
}
