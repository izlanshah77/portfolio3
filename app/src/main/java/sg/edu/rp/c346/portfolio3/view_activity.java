package sg.edu.rp.c346.portfolio3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class view_activity extends AppCompatActivity {

    TextView tvDate, tvType, tvDistance, tvTime, tvCal;
    Button btnBack;
    LinearLayout viewView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activity);

        //declare
        btnBack = findViewById(R.id.buttonBack);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        tvType = findViewById(R.id.tvType);
        tvCal = findViewById(R.id.tvCal);
        tvDistance = findViewById(R.id.tvDistance);

        //fetch details and set
        Intent intentRecieved = getIntent();
        String type = intentRecieved.getStringExtra("type");
        String date = intentRecieved.getStringExtra("date");
        String distance = intentRecieved.getStringExtra("distance");
        String time = intentRecieved.getStringExtra("time");
        String cal = intentRecieved.getStringExtra("cals");

        tvType.setText(type);
        tvDate.setText(date);
        tvDistance.setText(distance + "KM");
        tvTime.setText(time + "mins");
        tvCal.setText(cal);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("prefs",0);
        int theme = sharedPreferences.getInt("theme",999);
        viewView = findViewById(R.id.viewView);
        if(theme == 1){
            viewView.setBackgroundResource(R.drawable.background_black);
        }else{
            viewView.setBackgroundResource(R.drawable.background1);
        }

    }
}
