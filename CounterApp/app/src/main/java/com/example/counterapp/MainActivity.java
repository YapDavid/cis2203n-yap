package com.example.counterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int mCounter = 0;
    private TextView tvCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        Button btnIncrease = findViewById(R.id.btnIncrease);

        // Restore counter if app is recreated after rotation
        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt("COUNT_KEY", 0);
        }

        tvCounter.setText(String.valueOf(mCounter));

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;
                tvCounter.setText(String.valueOf(mCounter));
            }
        });
    }

    // Save counter value before rotation
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", mCounter);
    }

    // Restore counter value after rotation
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter = savedInstanceState.getInt("COUNT_KEY");
        tvCounter.setText(String.valueOf(mCounter));
    }
}