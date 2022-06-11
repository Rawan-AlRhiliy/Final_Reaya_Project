package com.example.reaya_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }
    public void move_Home(View view) {
        Intent switchActivityIntent = new Intent(this,HomeActivity.class);
        startActivity(switchActivityIntent);
    }
}