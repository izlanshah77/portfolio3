package sg.edu.rp.c346.portfolio3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {

    TextView tvBMI;
    Button btnSave, btnBack;
    EditText etHeight, etWeight;
    LinearLayout bmiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        tvBMI = findViewById(R.id.tvBMI);
        btnBack = findViewById(R.id.button);
        btnSave = findViewById(R.id.btnSaveBMI);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);

        etWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(etWeight.getText().length() >= 0 ){
                    double height = Double.parseDouble(etHeight.getText().toString());
                    double heightM = height/100;
                    double weight = Double.parseDouble(etWeight.getText().toString());

                    double bmi = weight/(heightM * heightM);

                    tvBMI.setText(String.format("%2f", bmi));

                }else{
                    tvBMI.setText("0");
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height = Double.parseDouble(etHeight.getText().toString());
                double heightM = height/100;
                double weight = Double.parseDouble(etWeight.getText().toString());

                double bmi = weight/(heightM * heightM);

                SharedPreferences pref = getSharedPreferences("prefs", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("BMI",String.format("%2f",bmi));
                editor.putString("Height", Double.toString(height));
                editor.putString("Weight", Double.toString(weight));
                editor.commit();

                Toast toast = Toast.makeText(BMIActivity.this, "BMI Saved in profile", Toast.LENGTH_LONG);
                toast.show();

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
    public void onResume(){
        super.onResume();

        SharedPreferences mPref = getSharedPreferences("prefs", 0);
        String bmi = mPref.getString("BMI",null);
        String height = mPref.getString("Height", null);
        String weight = mPref.getString("Weight",null);
        if(bmi != null){
            tvBMI = findViewById(R.id.tvBMI);
            tvBMI.setText(bmi);
        }
        if(height != null){
            etHeight = findViewById(R.id.etHeight);
            etHeight.setText(height);
        }
        if(weight != null){
            etWeight = findViewById(R.id.etWeight);
            etWeight.setText(weight);
        }

        SharedPreferences sharedPreferences = getSharedPreferences("prefs",0);
        int theme = sharedPreferences.getInt("theme",999);
        bmiView = findViewById(R.id.bmiActivity);
        if(theme == 1){
            bmiView.setBackgroundResource(R.drawable.background_black);
        }else{
            bmiView.setBackgroundResource(R.drawable.background1);
        }

    }

}
