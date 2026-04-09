package com.example.exercise2pt2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etStudentId, etPassword;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etStudentId = findViewById(R.id.et_student_id);
        etPassword = findViewById(R.id.et_password);
        btnSubmit = findViewById(R.id.btn_submit);
        tvResult = findViewById(R.id.tv_result);

        btnSubmit.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin() {
        String studentId = etStudentId.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (studentId.length() < 2) {
            tvResult.setText("Enter a valid Student ID.");
            return;
        }

        String lastTwo = studentId.substring(studentId.length() - 2);
        String correctPassword = "blue" + lastTwo;

        if (password.equals(correctPassword)) {
            tvResult.setText("Access granted!");
        } else {
            tvResult.setText("Wrong password. Try again.");
        }
    }
}