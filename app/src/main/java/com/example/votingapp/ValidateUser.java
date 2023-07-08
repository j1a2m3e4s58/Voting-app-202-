package com.example.votingapp;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ValidateUser extends AppCompatActivity {
    private String[] nationalIds = {"10966685", "12345678", "87654321", "98765432", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888"};

    private Button validate_btn;
    private EditText nationalIDEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_user);

        nationalIDEditText = findViewById(R.id.nationalIdEditText);

        validate_btn = (Button) findViewById(R.id.validate_btn);
        validate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyVoter(nationalIDEditText.getText().toString())) {
                    Intent intent = new Intent(ValidateUser.this, VotingActivity.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid ID", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    private boolean verifyVoter(String nationalId) {
        // Simulated voter verification using the national ID
        for (String id : nationalIds) {
            if (nationalId.equals(id)) {
                return true;
            }
        }
        return false;
    }
}

