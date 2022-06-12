package com.example.reaya_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
private ImageView Iexit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Iexit=findViewById(R.id.exit);
        Iexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomeActivity.this,StartActivity.class));
            }
        });

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
        Intent switchActivityIntent = new Intent(this, AppointmentsRecordActivity.class);
        startActivity(switchActivityIntent);
    }

    public void move_appointment_reservation(View view){
        Intent switchActivityIntent = new Intent(this, AppointmentsReservationActivity.class);
        startActivity(switchActivityIntent);
    }

    public void move_settings(View view){

    }
}