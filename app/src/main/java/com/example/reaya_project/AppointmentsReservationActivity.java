package com.example.reaya_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class AppointmentsReservationActivity extends AppCompatActivity implements AppointmentsReservationAdapter.OnClickListener {
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
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Covid 19 Smear (20SR)", "0", R.drawable.img_vector_3));
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Blood Tests (100SR)", "0", R.drawable.img_vector_3));
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Visit a GP (50SR)", "0", R.drawable.img_vector_3));
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Obstetrician and Gynecologist  (75SR)", "0", R.drawable.img_vector_3));
        AppointmentsReservationModellArrayList.add(new com.example.reaya_project.AppointmentsReservationModel("Pediatrician  (99SR)", "0", R.drawable.img_vector_3));
        // we are initializing our adapter class and passing our arraylist to it.
        AppointmentsReservationAdapter ReservationAdapter = new AppointmentsReservationAdapter(this, AppointmentsReservationModellArrayList, this);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        AppointmentReservationRV.setLayoutManager(linearLayoutManager);
        AppointmentReservationRV.setAdapter(ReservationAdapter);


    }


    public void move_pay(View view) {
        Intent switchActivityIntent = new Intent(this,PaymentActivity.class);
        startActivity(switchActivityIntent);
    }


    @Override
    public void onClick(int position) {
        String number = AppointmentsReservationModellArrayList.get(position).getappointments_number();
        int number_After_add = ((Integer.parseInt(number))+1);
        AppointmentsReservationModellArrayList.get(position).setappointments_number(number_After_add+"");
        AppointmentsReservationAdapter ReservationAdapter = new AppointmentsReservationAdapter(this, AppointmentsReservationModellArrayList, this);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        AppointmentReservationRV.setLayoutManager(linearLayoutManager);
        AppointmentReservationRV.setAdapter(ReservationAdapter);

    }
}
