package team42.cs2340.rattrackingapp.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

import team42.cs2340.rattrackingapp.Model.Month;
import team42.cs2340.rattrackingapp.Model.Sighting;
import team42.cs2340.rattrackingapp.Model.SightingList;
import team42.cs2340.rattrackingapp.R;

import static android.content.ContentValues.TAG;

public class GraphActivity extends AppCompatActivity {

    private Spinner monthSpinner;
    private Spinner monthSpinner2;
    private Spinner yearSpinner;
    private Spinner yearSpinner2;

    HashMap<Integer, Integer> elDataMap;
    BarChart barChart;
    ArrayList<String> dates;
    Random random;
    ArrayList<BarEntry> barEntries;
    SightingList sightingList;
    ArrayList<Sighting> sightingArrayList;
    ArrayList<String> elDate;
    int startMonth = 9;
    int startYear = 2015;
    String endMonth = "9";
    String endYear = "2015";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        elDataMap = new HashMap<>();
        barChart = (BarChart) findViewById(R.id.bargraph);

        sightingList = SightingList.getInstance();
        sightingArrayList = sightingList.getsightingList();

        elDate = new ArrayList<>();
        String adder;
        do {
            Log.d("BEATRICE", "HEY" + startMonth + startYear);
            adder = "" + startMonth + startYear;
            if (!elDataMap.containsKey(adder.hashCode())) {
                elDataMap.put(adder.hashCode(), 0);
            }
            elDate.add(adder);
            if(startMonth != 12) {
                startMonth++;
            } else {
                startMonth = 1;
                startYear++;
            }
        } while(!adder.equals(endMonth + endYear));

        createRandomBarGraph();

        Button search = (Button) findViewById(R.id.confirmgraphdate);
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
                elDate = new ArrayList<>();
                elDataMap = new HashMap<>();
                barChart.clear();
                String adder;
                do {
//                    Log.d("BEATRICE", "HEY" + startMonth + startYear);
                    adder = "" + startMonth + startYear;
                    Log.d("BEATRICE", adder);
                    elDate.add(adder);
                    elDataMap.put(adder.hashCode(), 0);
                    if(startMonth != 12) {
                        startMonth++;
                    } else {
                        startMonth = 1;
                        startYear++;
                    }
                } while(!adder.equals(endMonth + endYear));
            createRandomBarGraph();
            }
        });
    }

    public void createRandomBarGraph(){

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        populateSpinner();

        try {
//            Date date1 = simpleDateFormat.parse(Date1);
//            Date date2 = simpleDateFormat.parse(Date2);

//            Calendar mDate1 = Calendar.getInstance();
//            Calendar mDate2 = Calendar.getInstance();
//            mDate1.clear();
//            mDate2.clear();
//
//            mDate1.setTime(date1);
//            mDate2.setTime(date2);

//            dates = new ArrayList<>();
//            dates = getList(mDate1,mDate2);

            barEntries = new ArrayList<>();
            float max = 0f;
            float value = 0f;
            random = new Random();

            for (Sighting sighting : sightingArrayList) {
//                Log.d("JTest", sighting.getDate().toString());
                StringTokenizer tokens = new StringTokenizer(sighting.getDate().toString(), "/");
                String first = tokens.nextToken();
                String second = tokens.nextToken();
                String third = tokens.nextToken().substring(0,4);
                Log.d("JTest", first + third);
                Integer key = (first + third).hashCode();
                if (elDataMap.containsKey(key)) {
                    int replace = elDataMap.get(key);
                    elDataMap.put(key, ++replace);
                }
            }
            int i = 0;
            for (String date : elDate) {
                if (elDataMap.containsKey(date.hashCode())) {
                    int placement = elDataMap.get(date.hashCode());
                    barEntries.add(new BarEntry(placement, i++));
                }
            }
//            for(int j = 0; j< elDate.size();j++){
//
////                max = 100f;
////                value = random.nextFloat()*max;
//                barEntries.add(new BarEntry(value,j));
//            }



        }catch(Exception e){
            e.printStackTrace();
        }

        BarDataSet barDataSet = new BarDataSet(barEntries,"Dates");
        BarData barData = new BarData(elDate,barDataSet);
        barChart.setData(barData);
        barChart.setDescription("My First Bar Graph!");
    }

    public ArrayList<String> getList(Calendar startDate, Calendar endDate){
        ArrayList<String> list = new ArrayList<String>();
        while(startDate.compareTo(endDate)<=0){
            list.add(getDate(startDate));
            startDate.add(Calendar.DAY_OF_MONTH,1);
        }
        return list;
    }

    public String getDate(Calendar cld){
        String curDate = cld.get(Calendar.YEAR) + "/" + (cld.get(Calendar.MONTH) + 1) + "/"
                +cld.get(Calendar.DAY_OF_MONTH);
        try{
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(curDate);
            curDate =  new SimpleDateFormat("yyy/MM/dd").format(date);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return curDate;
    }

    public void populateSpinner() {
        monthSpinner = (Spinner) findViewById(R.id.searchmonth_SpinnerGraph);
        yearSpinner = (Spinner) findViewById(R.id.searchyear_SpinnerGraph);
        monthSpinner2 = (Spinner) findViewById(R.id.searchmonth_Spinner2Graph);
        yearSpinner2 = (Spinner) findViewById(R.id.searchyear_Spinner2Graph);


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


}