package com.example.reaya_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUpActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);
        final EditText name =(EditText) findViewById(R.id.Name);
        final EditText email = (EditText)findViewById(R.id.Email);
        final EditText phone = (EditText)findViewById(R.id.Phone);
        final Spinner gender= (Spinner) findViewById(R.id.Gender);
        final EditText birthday =(EditText) findViewById(R.id.Birthday);


        Button next = (Button) findViewById(R.id.NextC);
        next.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        String names=name.getText().toString();
                        String emails=email.getText().toString();
                        String value= phone.getText().toString();
                        int phones=Integer.parseInt(value);
                        String selectedItem=gender.getSelectedItem().toString();
                        String birthdays= birthday.getText().toString();

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
}