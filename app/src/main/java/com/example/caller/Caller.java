package com.example.caller;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Caller extends AppCompatActivity {
    private EditText phoneNumber;
    private ImageButton call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);

        phoneNumber = findViewById(R.id.PhoneNumber);
        call = findViewById(R.id.Call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });
    }

    private void makePhoneCall() {
        String number = phoneNumber.getText().toString();
        number = number.trim();
        if(number.length()==10 || number.length()== 12 || number.length()== 13 || number.length()== 14){
            String dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
        else{
            Toast.makeText(Caller.this, "Enter valid number", Toast.LENGTH_SHORT).show();
        }
    }
}