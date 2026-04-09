package com.example.inputactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EchoActivity extends AppCompatActivity {

    private static final String TAG = "EchoActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        Log.d(TAG, "onCreate started");

        TextView tvMessage = findViewById(R.id.tvMessage);
        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE_KEY");

        if (message != null) {
            tvMessage.setText(message);
            Log.d(TAG, "Message received: " + message);
        }
    }
}