package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import team42.cs2340.rattrackingapp.R;

import static android.content.ContentValues.TAG;


/**
 * Page used to pre-filter the data into the desired range.
 */
public class SearchDataActivity extends Activity {
    private Button searchByDateButton;
    private Button graphByDateButton;

    /**
     * Creates the page for the user to select the pre-filter data range.
     * @param savedInstanceState the instance used to create the search page.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchdata);

        searchByDateButton = (Button) findViewById(R.id.searchdatebtn);
        graphByDateButton = (Button) findViewById(R.id.graphbtn);


        searchByDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Pressed");
                startActivity(new Intent(SearchDataActivity.this
                        , SearchDateActivity.class));
            }
        });

        graphByDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchDataActivity.this,
                        GraphActivity.class));
            }
        });
    }
}