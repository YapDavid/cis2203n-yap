package com.example.inputactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    private static final String TAG = "InputActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Log.d(TAG, "onCreate started");

        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSend = findViewById(R.id.btnSend);
        Button btnShare = findViewById(R.id.btnShare);

        btnSend.setOnClickListener(v -> {
            String message = etMessage.getText().toString();
            Log.d(TAG, "Send clicked: " + message);
            Intent intent = new Intent(InputActivity.this, EchoActivity.class);
            intent.putExtra("MESSAGE_KEY", message);
            startActivity(intent);
        });

        btnShare.setOnClickListener(v -> {
            String message = etMessage.getText().toString();
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        });
    }
}