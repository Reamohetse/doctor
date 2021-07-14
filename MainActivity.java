package com.example.doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MaintActivity";
    private EditText mDisplay,mfirstName,mlastName,mgender, memail, mpassword;
    private Button mbutton,mbutton1;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this,"Appointment Sucessfully made",Toast.LENGTH_LONG).show();

        mfirstName = (EditText) findViewById(R.id.editTextTextPersonName);
        mlastName = (EditText) findViewById(R.id.editTextTextPersonName2);
        mgender = (EditText) findViewById(R.id.editTextTextPersonName3);
        mDisplay = (EditText) findViewById(R.id.editTextTextPersonName4);
        memail = (EditText) findViewById(R.id.editTextTextPersonName5);
        mpassword = (EditText) findViewById(R.id.editTextTextPersonName6);
        mbutton = (Button) findViewById(R.id.button);
        mbutton1 = (Button) findViewById(R.id.button2);
        fAuth = FirebaseAuth.getInstance();

        /*if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), appointments.class));
            finish();
        }*/
         mbutton1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getApplicationContext(), appointments.class));
             }
         });
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    memail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("Password required");
                    return;
                }
                if(password.length() < 6){
                    mpassword.setError("Password must greater than 6 characters");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Appointment made", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(getApplicationContext(), appointments.class));
                        }else{
                            Toast.makeText(MainActivity.this,"Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth, mDateSetListener, year, month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int month, int day, int year) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy" + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                mDisplay.setText(date);
            }
        };
    }
}