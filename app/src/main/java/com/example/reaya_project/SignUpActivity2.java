package com.example.reaya_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity2 extends AppCompatActivity {
    //Prevous page: name; email; phone; geneder; birthday;
    //This page: userid; city; address; password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        String name = extras.getString("name");
        String email = extras.getString("email");
        int phone = extras.getInt("phone",0);
        String gender = extras.getString("gendernumber");
        String birthday = extras.getString("birthday");
        //values taken from prevous page
        /*Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        int phone = intent.getIntExtra("phone",0);
        String gender = intent.getStringExtra("gendernumber");
        String birthday = intent.getStringExtra("birthday");*/
        //-------------------------------------------------------------
        String gendervalue="";
        if(gender=="0"){
            gendervalue="Male";
        }else {
            gendervalue="Female";
        }

        Button submit = findViewById(R.id.send);
        DAOPatient dao = new DAOPatient();
        String finalGendervalue = gendervalue;
        submit.setOnClickListener(view -> {
            final EditText userId = findViewById(R.id.UserId);
            final EditText city = findViewById(R.id.City);
            final EditText address = findViewById(R.id.Address);
            final EditText password = findViewById(R.id.PasswordC);
            int UserIdint = Integer.parseInt(userId.getText().toString());
            Patient pat = new Patient(name,email,phone, finalGendervalue,birthday,UserIdint,city.getText().toString(),address.getText().toString(),password.getText().toString());

            /* I Will Remove this comment symbol but I put this because this makes an Error in my app

            dao.add(pat).addOnSuccessListener(suc->
            {
                Toast.makeText(this,"Account Created Successfully", Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er->
            {
                Toast.makeText(this,""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
            */
            Intent switchActivityIntent = new Intent(this, HomeActivity.class);
            startActivity(switchActivityIntent);
        });
    }
    public void move_signin(View view){
        Intent switchActivityIntent = new Intent(this, SignInActivity.class);
        startActivity(switchActivityIntent);
    }
}