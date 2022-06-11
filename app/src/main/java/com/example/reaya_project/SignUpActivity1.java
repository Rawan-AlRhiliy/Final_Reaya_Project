package com.example.reaya_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.regex.Pattern;

public class SignUpActivity1 extends AppCompatActivity {
    private EditText name ;
    private EditText email ;
    private EditText phone;
    private Spinner gender;
    private EditText birthday ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);




        Button next = (Button) findViewById(R.id.NextC);
        next.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        name =(EditText) findViewById(R.id.name);
                        email = (EditText)findViewById(R.id.Email);
                        phone = (EditText)findViewById(R.id.Phone);
                        gender= (Spinner) findViewById(R.id.Gender);
                        birthday =(EditText) findViewById(R.id.Birthday);

                        String names=name.getText().toString();
                        String emails=email.getText().toString();
                        String value= phone.getText().toString();
                        int phones=Integer.parseInt(value);
                        String selectedItem=gender.getSelectedItem().toString();
                        String birthdays= birthday.getText().toString();
                        //validation2();
                        if(names.isEmpty()){
                            name.setError("Name is required");
                            name.requestFocus();
                            return;
                        }
                        if(emails.isEmpty()){
                            email.setError("Email is required");
                            email.requestFocus();
                            return;
                        }
                        if(value.isEmpty()){
                            phone.setError("Phone is required");
                            phone.requestFocus();
                            return;
                        }
                        if(birthdays.isEmpty()){
                            birthday.setError("Birthday is required");
                            birthday.requestFocus();
                            return;
                        }
                        if(!Patterns.EMAIL_ADDRESS.matcher(emails).matches()){
                            email.setError("Please provide a valid email !");
                            email.requestFocus();
                            return;
                        }

                        Intent i = new Intent (SignUpActivity1.this, SignUpActivity2.class);
                        /*i.putExtra("name", names);
                        i.putExtra("email", emails);
                        i.putExtra("phone", phones);
                        i.putExtra("gendernumber", selectedItem);//male: 0, female: 1
                        i.putExtra("birthday", birthdays);*/
                        Bundle extras = new Bundle();
                        extras.putString("name", names);
                        extras.putString("email", emails);
                        extras.putInt("phone", phones);
                        extras.putString("gendernumber", selectedItem);
                        extras.putString("birthday", birthdays);
                        i.putExtras(extras);
                        Log.e("myTag", "ERRROR");
                        Log.d("myTag", "This is my message");
                        System.out.println("End of page 1");
                        startActivity(i);

                    }
                });

      /*  next.setOnClickListener(View ->{
            Intent i = new Intent (this, SignUpActivity2.class);
            i.putExtra("name", name.getText());
            i.putExtra("email", email.getText());
            i.putExtra("phone", phone.getText());
            i.putExtra("gendernumber", selectedItem);//male: 0, female: 1
            i.putExtra("birthday", birthday.getText());
            startActivity(i);
        });*/


    }

    public void move_signin(View view){
        Intent switchActivityIntent = new Intent(this, SignInActivity.class);
        startActivity(switchActivityIntent);
    }
}