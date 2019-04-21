package sg.edu.rp.c346.portfolio3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class TrackerActivity extends AppCompatActivity {

    ListView lvActivity;
    ArrayList<Activity> alActivity;
    CustomAdapter caActivity;
    Button btnAdd, btnBack;
    TextView tvCounter;
    LinearLayout trackerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        tvCounter = findViewById(R.id.tvCounter);



        //LISTVIEW STUFF
        alActivity = new ArrayList<>();
        lvActivity = (ListView) findViewById(R.id.lvActivity);
        Activity activity1 = new Activity("Running", "06/04/2000", "4", "22");
        Activity activity2 = new Activity("Swimming", "06/04/2000", "4", "28");
        alActivity.add(activity1);
        alActivity.add(activity2);
        caActivity = new CustomAdapter(this, R.layout.activity_row, alActivity);
        lvActivity.setAdapter(caActivity);

        int Counter = alActivity.size();
        tvCounter.setText(Integer.toString(Counter));



        //buttons

        btnBack = findViewById(R.id.buttonHome);
        btnAdd = findViewById(R.id.buttonAdd);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int requestCode = 1;
                Intent intentAdd = new Intent(TrackerActivity.this, AddActivity.class);
                TrackerActivity.this.startActivityForResult(intentAdd, requestCode);
            }
        });

        lvActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intentView = new Intent(TrackerActivity.this, view_activity.class);
                Activity activity = alActivity.get(i);
                intentView.putExtra("type", activity.getType());
                intentView.putExtra("date",activity.getDate());
                intentView.putExtra("distance",activity.getDistance());
                intentView.putExtra("time",activity.getTime());
                intentView.putExtra("cals",Double.toString(activity.getCals()));
                caActivity.notifyDataSetChanged();

                startActivity(intentView);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == AddActivity.RESULT_OK){
            if(data != null){
                String type1 = "";
                int type = data.getIntExtra("type",90);
                if(type == 0){
                    type1 = "Running";
                }else if(type == 1){
                    type1 = "Swimming";
                }else if(type == 2){
                    type1 = "Walking";
                }else if(type == 3){
                    type1 = "Cycling";
                }else{
                    type1 = "Not working";
                }

                String date = data.getStringExtra("date");
                String distance = data.getStringExtra("distance");
                String time = data.getStringExtra("time");
                Activity a = new Activity(type1,date,distance,time);
                alActivity.add(a);
                caActivity.notifyDataSetChanged();
                int Counter = alActivity.size();
                tvCounter.setText(Integer.toString(Counter));
            }
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("prefs",0);
        int theme = sharedPreferences.getInt("theme",999);
        trackerView = findViewById(R.id.trackView);
        if(theme == 1){
            trackerView.setBackgroundResource(R.drawable.alt_back_black);
        }else{
            trackerView.setBackgroundResource(R.drawable.alt_back);
        }

    }


}
