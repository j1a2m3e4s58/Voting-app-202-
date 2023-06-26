package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VotingActivity extends AppCompatActivity {

    private TextView titleTextView, candidatesTextView, nationalIdLabel, voteLabel, resultTextView, winnerTextView;
    private EditText nationalIdEditText, voteEditText;
    private Button verifyButton, voteButton;
    private LinearLayout voteLayout;

    private String[] candidates = {"Nana Akufo-Addo", "John Mahama", "Ivor Greenstreet", "Akua Donkor"};
    private int[] voteCounts = {0, 0, 0, 0};

    private String[] nationalIds = {"10966685", "12345678", "87654321", "98765432", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        titleTextView = findViewById(R.id.titleTextView);
        nationalIdLabel = findViewById(R.id.nationalIdLabel);
        voteLabel = findViewById(R.id.voteLabel);
        resultTextView = findViewById(R.id.resultTextView);
        winnerTextView = findViewById(R.id.winnerTextView);

        nationalIdEditText = findViewById(R.id.nationalIdEditText);
        voteEditText = findViewById(R.id.voteEditText);

        verifyButton = findViewById(R.id.verifyButton);
        voteButton = findViewById(R.id.voteButton);

        voteLayout = findViewById(R.id.voteLayout);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nationalId = nationalIdEditText.getText().toString();
                if (verifyVoter(nationalId)) {
                    nationalIdEditText.setEnabled(false);
                    verifyButton.setEnabled(false);
                    voteLayout.setVisibility(View.VISIBLE);
                } else {
                    // Verification failed
                    // Show an error message or take appropriate action
                    nationalIdEditText.setText("Id doesn't exist");
                }
            }
        });

        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vote = Integer.parseInt(voteEditText.getText().toString());
                if (vote >= 1 && vote <= candidates.length) {
                    voteCounts[vote - 1]++;
                    voteEditText.setText("");
                    // Show a success message or take appropriate action
                } else {
                    // Invalid vote
                    // Show an error message or take appropriate action
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
