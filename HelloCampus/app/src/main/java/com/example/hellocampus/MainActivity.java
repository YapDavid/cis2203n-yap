package com.example.hellocampus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvDepartment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Student ID in Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 24104748");
        }

        tvDepartment = findViewById(R.id.tvDepartment);
        Button btnChangeName = findViewById(R.id.btnChangeName);

        btnChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDepartment.setText("Ms. Angie M. Ceniza-Canillo");
            }
        });
    }
}