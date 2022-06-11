package com.example.reaya_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountActivity extends AppCompatActivity {
//rahaf trial
    private FirebaseUser user;
    private DatabaseReference refrence;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        user= FirebaseAuth.getInstance().getCurrentUser();
        refrence= FirebaseDatabase.getInstance().getReference("Patient");
        userID=user.getUid();
        final TextView phoneTV=findViewById(R.id.phone);
        final TextView genderTV=findViewById(R.id.gender);
        final TextView birthdayTV=findViewById(R.id.birthday);
        final TextView cityTV=findViewById(R.id.city);
        final TextView addressTV=findViewById(R.id.address);
        final TextView userIdTV=findViewById(R.id.userId);
        final TextView nameTV=findViewById(R.id.name);
        refrence.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Patient UserProfile =snapshot.getValue(Patient.class);
                if(UserProfile != null){
                    //int Phone = UserProfile.getPhone();
                    String name=UserProfile.getName();;
                    String PhoneString=String.valueOf(UserProfile.getPhone());
                    String Gender =UserProfile.getGeneder();
                    String Birthday =UserProfile.getBirthday();
                    String City =UserProfile.getCity();
                    String Address =UserProfile.getAddress();
                    String Userid =String.valueOf(UserProfile.getUserid());

                    //--------------------------------------
                    nameTV.setText(name);
                    phoneTV.setText(PhoneString);
                    genderTV.setText(Gender);
                    birthdayTV.setText(Birthday);
                    cityTV.setText(City);
                    addressTV.setText(Address);
                    userIdTV.setText(Userid);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AccountActivity.this,"Somthing wrong happened!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}