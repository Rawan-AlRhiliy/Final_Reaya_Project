package com.example.reaya_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaymentActivity extends AppCompatActivity {
    private EditText cardN;
    private EditText cardD;
    private EditText cardC;
    private EditText cardName;
    private Button payment;
    //pay2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        cardN=findViewById(R.id.CardN);
        cardD=findViewById(R.id.CardDate);
        cardC=findViewById(R.id.CardCvc);
        cardName=findViewById(R.id.CardName);
        payment=findViewById(R.id.pay2);
        payment.setOnClickListener(view -> {
            String Card_Number=cardN.getText().toString();
            String Card_Date=cardD.getText().toString();
            String Card_CVC= cardC.getText().toString();
            String Card_Name=cardName.getText().toString();
            if(Card_Number.isEmpty()){
                cardN.setError("Card Number is required");
                cardN.requestFocus();
                return;
            }
            if(Card_Date.isEmpty()){
                cardD.setError("Card Date is required");
                cardD.requestFocus();
                return;
            }
            if(Card_CVC.isEmpty()){
                cardC.setError("CVC is required");
                cardC.requestFocus();
                return;
            }
            if(Card_Name.isEmpty()){
                cardName.setError("Name is required");
                cardName.requestFocus();
                return;
            }
            if(Card_Number.length() != 16){
                cardN.setError("Card Number length should eb 16 digits");
                cardN.requestFocus();
                return;
            }
            if(Card_CVC.length() != 3){
                cardC.setError("CVC is only 3 digits");
                cardC.requestFocus();
                return;
            }

            Intent switchActivityIntent = new Intent(this,HomeActivity.class);
            startActivity(switchActivityIntent);
        });
            //-------------- this page information:------------
    }

}