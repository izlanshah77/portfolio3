package sg.edu.rp.c346.portfolio3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class profileActivity extends AppCompatActivity {

    Button btnBack, btnEdit;
    ImageView ivProfile;
    TextView tvAge, tvHeight, tvWeight, tvBMI, tvName;
    LinearLayout profileView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnBack = findViewById(R.id.BUTTONHOME);
        btnEdit = findViewById(R.id.BUTTONEDIT);
        ivProfile = findViewById(R.id.imageView9);
        tvAge = findViewById(R.id.tvAge);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);
        tvBMI = findViewById(R.id.tvBMI);
        tvName = findViewById(R.id.textGrid);

        SharedPreferences mPrefs = getSharedPreferences("prefs",0);
        String Height  = mPrefs.getString("Height",null);
        String Weight = mPrefs.getString("Weight",null);
        String BMI = mPrefs.getString("BMI",null);

        if(Height != null){
            tvHeight.setText(Height + "cm");
        }
        if(Weight != null){
            tvWeight.setText(Weight + "kg");
        }
        if(BMI != null){
            tvBMI.setText(BMI);
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int requestCode  = 1;
                Intent intentEdit = new Intent(profileActivity.this, editProfile.class);
                profileActivity.this.startActivityForResult(intentEdit, requestCode);

            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == profileActivity.RESULT_OK){

            if(data != null){
                tvAge.setText(data.getStringExtra("age"));
                tvName.setText(data.getStringExtra("name"));


            }
        }
    }

    @Override
    public void onResume(){
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("prefs",0);
        String name = sharedPreferences.getString("name",null);
        String age = sharedPreferences.getString("age",null);
        int theme = sharedPreferences.getInt("theme",999);
        profileView = findViewById(R.id.profileView);
        if(theme == 1){
            profileView.setBackgroundResource(R.drawable.background_black);
            tvAge.setTextColor(Color.parseColor("#ffffff"));
            tvName.setTextColor(Color.parseColor("#ffffff"));
            tvBMI.setTextColor(Color.parseColor("#ffffff"));
            tvWeight.setTextColor(Color.parseColor("#ffffff"));
            tvHeight.setTextColor(Color.parseColor("#ffffff"));
        }else{
            profileView.setBackgroundResource(R.drawable.background1);
        }

        if(name != null){
            tvName.setText(name);
        }
        if(age != null){
            tvAge.setText(age);
        }

    }
}
