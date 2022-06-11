package com.example.reaya_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {
private EditText email;
private EditText password;
private Button login;
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email=findViewById(R.id.email);
        password=findViewById(R.id.Password);
        login=(Button) findViewById(R.id.login);
        mAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(view -> {
            String emails=email.getText().toString().trim();
            String passwords=password.getText().toString().trim();

            if(emails.isEmpty()){
                email.setError("City is required");
                email.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(emails).matches()){
                email.setError("Please provide a valid email !");
                email.requestFocus();
                return;
            }
            if(passwords.isEmpty()){
                password.setError("Password is required");
                password.requestFocus();
                return;
            }
            if(passwords.length()<6){
                password.setError("Password length should be more than 6 characters");
                password.requestFocus();
                return;
            }
            mAuth.signInWithEmailAndPassword(emails,passwords).addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull  Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                //FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

                                //redirect
                                Intent switchActivityIntent = new Intent(SignInActivity.this, HomeActivity.class);
                                startActivity(switchActivityIntent);
                            }else{
                                Toast.makeText(SignInActivity.this,"Failed to LogIn", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
            );
        });

    }


    public void move_signup(View view){
        Intent switchActivityIntent = new Intent(this, SignUpActivity1.class);
        startActivity(switchActivityIntent);
    }
}