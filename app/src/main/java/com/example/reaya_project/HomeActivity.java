package com.example.reaya_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void move_account_info(View view){
        Intent switchActivityIntent = new Intent(this, AccountActivity.class);
        startActivity(switchActivityIntent);
    }

    public void move_monthly_schedule(View view){
        Intent switchActivityIntent = new Intent(this, ScheduleActivity.class);
        startActivity(switchActivityIntent);
    }
    public void move_Contact_us(View view){
        Intent switchActivityIntent = new Intent(this, ContactUsActivity.class);
        startActivity(switchActivityIntent);
    }

    //--------------------------------------------------------------------------------
    public void move_appointments_record(View view){

    }
    public void move_appointment_reservation(View view){

    }

    public void move_settings(View view){

    }
}