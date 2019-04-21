package sg.edu.rp.c346.portfolio3;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class settings extends AppCompatActivity {

    Spinner spnTheme;
    Button btnHome, btnLogOut, btnSave;
    ArrayList<String> alTheme;
    ArrayAdapter<String> aaTheme;
    LinearLayout settingsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        spnTheme = findViewById(R.id.spinnerColor);
        btnHome = findViewById(R.id.btnHOME);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnSave = findViewById(R.id.btnSAVE);

        alTheme = new ArrayList<>();
        aaTheme = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alTheme);
        alTheme.add("Light");
        alTheme.add("Dark");
        aaTheme.notifyDataSetChanged();
        spnTheme.setAdapter(aaTheme);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theme = spnTheme.getSelectedItemPosition();

                SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("theme", theme);
                editor.commit();

                Toast toast = Toast.makeText(settings.this, "Saved in profile", Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(settings.this);
                myBuilder.setTitle("Reset Data?");
                myBuilder.setMessage("Are you sure you want to reset data?");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(settings.this, "Data Reset",Toast.LENGTH_LONG).show();
                        SharedPreferences preferences = getSharedPreferences("prefs",0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.clear();
                        editor.commit();
                        finish();
                    }
                });
                myBuilder.setNeutralButton("No",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
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
        settingsView = findViewById(R.id.settingsView);
        if(theme == 1){
            settingsView.setBackgroundResource(R.drawable.background_black);
        }else{
            settingsView.setBackgroundResource(R.drawable.background1);
        }

    }
}
