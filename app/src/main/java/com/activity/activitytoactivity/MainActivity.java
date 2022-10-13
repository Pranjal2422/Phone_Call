package com.activity.activitytoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.button1);


        //Function to call other activity
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
            }
        });

        //Function to call a phone number
        Button call = findViewById(R.id.call);
        EditText phone = findViewById(R.id.call_no);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_no = phone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phone_no));
                startActivity(intent);
            }
        });

        // Function to send sms
        Button sms = findViewById(R.id.sms);
        EditText smsph = findViewById(R.id.smsph);
        EditText smsmssg = findViewById(R.id.smsmssg);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               Intent i = new Intent(Intent.ACTION_SEND);
                SmsManager smsManager = SmsManager.getDefault();
                String phone = smsph.getText().toString();
                String message = smsmssg.getText().toString();
                smsManager.sendTextMessage(phone,null,message,null,null);
            }
        });
    }
}