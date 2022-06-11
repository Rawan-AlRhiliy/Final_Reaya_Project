package com.example.reaya_project;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppointmentsReservationAdapter extends RecyclerView.Adapter<AppointmentsReservationAdapter.Viewholder>{

    private Context context;
    private ArrayList<com.example.reaya_project.AppointmentsReservationModel> AppointmentRecordArrayList;
    private OnClickListener OnClickListener;

    // Constructor
    public AppointmentsReservationAdapter(Context context, ArrayList<com.example.reaya_project.AppointmentsReservationModel> AppointmentRecordArrayList, OnClickListener OnClickListenerReservation) {
        this.context = context;
        this.AppointmentRecordArrayList = AppointmentRecordArrayList;
        this.OnClickListener = OnClickListenerReservation;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_reservation, parent, false);
        return new Viewholder(view, OnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        com.example.reaya_project.AppointmentsReservationModel model = AppointmentRecordArrayList.get(position);
        holder.serName.setText(model.getserName());
        holder.appointments_number.setText(model.getappointments_number());
        holder.detail.setImageResource(model.getdetail());

    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return AppointmentRecordArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        private TextView serName, appointments_number;
        private ImageView detail;
        private Button pay;
        OnClickListener onClickListenerReservation;

        public Viewholder(@NonNull View itemView, OnClickListener onClickListenerReservation) {
            super(itemView);
            serName = itemView.findViewById(R.id.serName);
            appointments_number = itemView.findViewById(R.id.appointments_number);
            detail = itemView.findViewById(R.id.detail);
            this.onClickListenerReservation = onClickListenerReservation;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            onClickListenerReservation.onClick(getAdapterPosition());
        }
    }
    public interface OnClickListener {
        void onClick(int position);
    }
}
