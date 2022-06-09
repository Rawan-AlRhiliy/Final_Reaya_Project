package com.example.reaya_project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppointmentsReservationActivity extends AppCompatActivity {
    private RecyclerView AppointmentReservationRV;

    // Arraylist for storing data
    private ArrayList<com.example.reaya_project.AppointmentsReservationModel> AppointmentsReservationModellArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments_reservation);
        AppointmentReservationRV = findViewById(R.id.idRVreservation);

        // here we have created new array list and added data to it.
        AppointmentsReservationModellArrayList = new ArrayList<>();
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Covid 19 Smear", R.drawable.img_vector_3));
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Blood Tests", R.drawable.img_vector_3));
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Visit a GP", R.drawable.img_vector_3));
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Obstetrician and Gynecologist", R.drawable.img_vector_3));
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Pediatrician", R.drawable.img_vector_3));
        // we are initializing our adapter class and passing our arraylist to it.
        AppointmentsReservationAdapter ReservationAdapter = new AppointmentsReservationAdapter(this, AppointmentsReservationModellArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        AppointmentReservationRV.setLayoutManager(linearLayoutManager);
        AppointmentReservationRV.setAdapter(ReservationAdapter);
    }
}
