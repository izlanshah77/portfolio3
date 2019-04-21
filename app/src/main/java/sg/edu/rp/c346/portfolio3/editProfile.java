package sg.edu.rp.c346.portfolio3;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class editProfile extends AppCompatActivity {

    Button btnCancel, btnSave;
    EditText etName, etAge;
    LinearLayout editView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        btnCancel = findViewById(R.id.buttonHome);
        btnSave = findViewById(R.id.btnAdd);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(editProfile.this);
                myBuilder.setTitle("Cancel?");
                myBuilder.setMessage("Are you sure you want to cancel? any info will be lost.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(editProfile.this, "Cancelled",Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                myBuilder.setNeutralButton("No",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();

                Intent editedIntent = new Intent();
                editedIntent.putExtra("name", name);
                editedIntent.putExtra("age",age);
                setResult(RESULT_OK, editedIntent);

                SharedPreferences preferences = getSharedPreferences("prefs", 0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name",name);
                editor.putString("age",age);
                editor.commit();

                Toast toast = Toast.makeText(editProfile.this, "Saved in profile", Toast.LENGTH_LONG);
                toast.show();

                finish();
            }
        });


    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("prefs", 0);
        String name = sharedPreferences.getString("name",null);
        String age = sharedPreferences.getString("age",null);
        int theme = sharedPreferences.getInt("theme",999);
        editView = findViewById(R.id.editView);
        if(theme == 1){
            editView.setBackgroundResource(R.drawable.background_black);
        }else{
            editView.setBackgroundResource(R.drawable.background1);
        }

        if(name != null){
            etName.setText(name);
        }
        if(age != null){
            etAge.setText(age);
        }
    }
}
