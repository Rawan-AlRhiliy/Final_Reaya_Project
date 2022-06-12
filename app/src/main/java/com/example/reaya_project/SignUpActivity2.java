package com.example.reaya_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity2 extends AppCompatActivity {
    //Prevous page: name; email; phone; geneder; birthday;
    //This page: userid; city; address; password;
    private EditText userId;
    private EditText city ;
    private EditText address;
    private EditText password;
    private FirebaseAuth mAuth;

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
        //DAOPatient dao = new DAOPatient();
        String finalGendervalue = gendervalue;
        submit.setOnClickListener(view -> {
            //-------------- this page information:------------
            userId = findViewById(R.id.UserId);

            city = findViewById(R.id.City);
            address = findViewById(R.id.Address);
            password = findViewById(R.id.PasswordC);
            mAuth= FirebaseAuth.getInstance();
            //---------------------------------
            String Citys=city.getText().toString();
            String Addresss=address.getText().toString();
            String Passwords= password.getText().toString();
            String UsrId= userId.getText().toString();
            if(UsrId.isEmpty()){
                userId.setError("A value is required");
                userId.requestFocus();
                return;
            }
            if(Citys.isEmpty()){
                city.setError("City is required");
                city.requestFocus();
                return;
            }
            if(Addresss.isEmpty()){
                address.setError("Address is required");
                address.requestFocus();
                return;
            }
            if(Passwords.isEmpty()){
                 password.setError("Password is required");
                 password.requestFocus();
                return;
            }
            if(Passwords.length()<6){
                password.setError("Min password length should be 6 characters long");
                password.requestFocus();
                return;
            }
            int UserIdint = Integer.parseInt(userId.getText().toString());
            mAuth.createUserWithEmailAndPassword(email,Passwords)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Patient pat = new Patient(name,email,phone, finalGendervalue,birthday,UserIdint,Citys,Addresss ,Passwords);
                                FirebaseDatabase.getInstance().getReference("Patient")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(pat).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(SignUpActivity2.this,"Account Created Successfully", Toast.LENGTH_SHORT).show();


                                        }else{
                                            Toast.makeText(SignUpActivity2.this,"Failed to create an account", Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                }
                                        );

                            }else{

                                Toast.makeText(SignUpActivity2.this,"Failed to create an account", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }


            );
            /*Patient pat = new Patient(name,email,phone, finalGendervalue,birthday,UserIdint,Citys,Addresss ,Passwords);

            dao.add(pat).addOnSuccessListener(suc->
            {
                Toast.makeText(this,"Account Created Successfully", Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er->
            {
                Toast.makeText(this,""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });*/

            Intent switchActivityIntent = new Intent(this, HomeActivity.class);
            startActivity(switchActivityIntent);
        });
    }
    public void move_signin(View view){
        Intent switchActivityIntent = new Intent(this, SignInActivity.class);
        startActivity(switchActivityIntent);
    }

}