package sg.edu.rp.c346.portfolio3;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    Spinner spnActivities;
    EditText etDate, etTime, etDistance;
    Button btnAdd, btnBack;
    ArrayList<String> alTypes;
    ArrayAdapter<String> aaTypes;
    LinearLayout addView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        spnActivities = findViewById(R.id.spinnerType);
        alTypes = new ArrayList<>();
        aaTypes = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alTypes);
        spnActivities.setAdapter(aaTypes);

        alTypes.add("Running");
        alTypes.add("Swimming");
        alTypes.add("Walking");
        alTypes.add("Cycling");
        aaTypes.notifyDataSetChanged();


        etDate = findViewById(R.id.etDate);
        etDistance = findViewById(R.id.etDistance);
        etTime = findViewById(R.id.etTime);
        btnBack = findViewById(R.id.buttonHome);
        btnAdd = findViewById(R.id.btnAdd);



        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                etDate.setText( day + "/" + (month+1) + "/" + year);

            }
        };
        final DatePickerDialog myDateDialog = new DatePickerDialog(AddActivity.this, myDateListener, 2019,04,20);

        etDate.setClickable(true);
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDateDialog.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(AddActivity.this);
                myBuilder.setTitle("Cancel?");
                myBuilder.setMessage("Are you sure you want to cancel? any info will be lost.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AddActivity.this, "Cancelled",Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                myBuilder.setNeutralButton("No",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intentAddNew = new Intent();

                String time = etTime.getText().toString();
                String distance = etDistance.getText().toString();
                String date = etDate.getText().toString();
                int type = spnActivities.getSelectedItemPosition();

                intentAddNew.putExtra("type",type);
                intentAddNew.putExtra("date",date);
                intentAddNew.putExtra("distance", distance);
                intentAddNew.putExtra("time",time);
                setResult(RESULT_OK, intentAddNew);


                finish();

            }
        });




    }
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("prefs",0);
        int theme = sharedPreferences.getInt("theme",999);
        addView = findViewById(R.id.addView);
        if(theme == 1){
            addView.setBackgroundResource(R.drawable.background_black);
        }else{
            addView.setBackgroundResource(R.drawable.background1);
        }

    }
}
