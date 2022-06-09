package com.example.reaya_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppointmentsRecordActivity extends AppCompatActivity {
    private RecyclerView AppointmentRecordRV;

    // Arraylist for storing data
    private ArrayList<com.example.reaya_project.AppointmentRecordModel> AppointmentRecordModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments_record);
        AppointmentRecordRV = findViewById(R.id.idRVAppointmentRecor);

        // here we have created new array list and added data to it.
        AppointmentRecordModelArrayList = new ArrayList<>();
        AppointmentRecordModelArrayList.add(new com.example.reaya_project.AppointmentRecordModel("Dr. Ail Al-rhiliy", "10:00 AM","9/06/22","Active", R.drawable.arrow_icon__myiconfinder_23));
        AppointmentRecordModelArrayList.add(new com.example.reaya_project.AppointmentRecordModel("Dr. Khaled Al-Maliki", "10:00 AM","5/07/22","Active", R.drawable.arrow_icon__myiconfinder_23));
        AppointmentRecordModelArrayList.add(new com.example.reaya_project.AppointmentRecordModel("Dr. Ahmed Al-Hazmi", "10:00 AM","3/08/22","Active",R.drawable.arrow_icon__myiconfinder_23));
        AppointmentRecordModelArrayList.add(new com.example.reaya_project.AppointmentRecordModel("Dr. Ail Al-rhiliy", "10:00 AM","12/09/22","Active", R.drawable.arrow_icon__myiconfinder_23));
        AppointmentRecordModelArrayList.add(new com.example.reaya_project.AppointmentRecordModel("Dr. Khaled Al-Maliki", "10:00 AM","20/4/22","UnActive", R.drawable.arrow_icon__myiconfinder_23));
        AppointmentRecordModelArrayList.add(new com.example.reaya_project.AppointmentRecordModel("Dr. Ail Al-rhiliy", "10:00 AM","12/11/21","UnActive", R.drawable.arrow_icon__myiconfinder_23));
        AppointmentRecordModelArrayList.add(new com.example.reaya_project.AppointmentRecordModel("Dr. Ahmed Al-Hazmi", "10:00 AM","1/6/21","UnActive", R.drawable.arrow_icon__myiconfinder_23));

        // we are initializing our adapter class and passing our arraylist to it.
        AppointmentRecordAdapter courseAdapter = new AppointmentRecordAdapter(this, AppointmentRecordModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        AppointmentRecordRV.setLayoutManager(linearLayoutManager);
        AppointmentRecordRV.setAdapter(courseAdapter);
    }
    public void move_more_details(View view) {
        Intent switchActivityIntent = new Intent(this, DetailsActivity.class);
        startActivity(switchActivityIntent);
    }
}
