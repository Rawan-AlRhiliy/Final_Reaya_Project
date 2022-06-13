package com.example.reaya_project;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AppointmentRecordAdapter extends RecyclerView.Adapter<AppointmentRecordAdapter.Viewholder> {

    private Context context;
    private ArrayList<com.example.reaya_project.AppointmentRecordModel> AppointmentRecordArrayList;

    // Constructor
    public AppointmentRecordAdapter(Context context, ArrayList<com.example.reaya_project.AppointmentRecordModel> courseModelArrayList) {
        this.context = context;
        this.AppointmentRecordArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }
//
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        com.example.reaya_project.AppointmentRecordModel model = AppointmentRecordArrayList.get(position);
        holder.DrName.setText(model.getDrName());
        holder.Time.setText("" + model.getTime());
        holder.day.setText("" + model.getday());
        holder.state.setText("" + model.getstate());
        holder.image_detail.setImageResource(model.getimage_detail());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return AppointmentRecordArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView DrName, Time, day, state ;
        private ImageView image_detail;



        public Viewholder(@NonNull View itemView) {
            super(itemView);
            DrName = itemView.findViewById(R.id.DrName);
            Time = itemView.findViewById(R.id.Time);
            day = itemView.findViewById(R.id.day);
            state = itemView.findViewById(R.id.state);
            image_detail = itemView.findViewById(R.id.image_detail);
        }
    }
}
