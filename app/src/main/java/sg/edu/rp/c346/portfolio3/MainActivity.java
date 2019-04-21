package sg.edu.rp.c346.portfolio3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    LinearLayout homePageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        setToggleEvent(mainGrid);
    }


    private void setToggleEvent(GridLayout mainGrid){
        for(int i = 0; i < mainGrid.getChildCount();i++){
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int cardPos = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(cardPos == 0){
                        int requestCode = 0;
                        Intent intentBMI = new Intent(MainActivity.this, BMIActivity.class);
                        MainActivity.this.startActivityForResult(intentBMI, requestCode);
                    }
                    else if(cardPos == 1){
                        int requestCode = 0;
                        Intent intentActivity = new Intent(MainActivity.this, TrackerActivity.class);
                        MainActivity.this.startActivityForResult(intentActivity, requestCode);
                    }
                    else if(cardPos == 2){
                        int requestCode = 0;
                        Intent intentProfile = new Intent(MainActivity.this, profileActivity.class);
                        MainActivity.this.startActivityForResult(intentProfile, requestCode);
                    }
                    else if(cardPos == 3){
                        int requestCode = 0;
                        Intent intentSettings = new Intent(MainActivity.this, settings.class);
                        MainActivity.this.startActivityForResult(intentSettings, requestCode);
                    }

                }
            });
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("prefs",0);
        int theme = sharedPreferences.getInt("theme",999);
        homePageView = findViewById(R.id.homePageView);
        if(theme == 1){
            homePageView.setBackgroundResource(R.drawable.background_black);
        }else{
            homePageView.setBackgroundResource(R.drawable.background1);
        }

    }
}
