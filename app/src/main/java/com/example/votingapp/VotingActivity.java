package com.example.votingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;

public class VotingActivity extends AppCompatActivity {

    private TextView titleTextView, candidatesTextView, nationalIdLabel, voteLabel, resultTextView, winnerTextView;
    private Button verifyButton, voteButton;
    private RadioGroup candidatesRadioGroup;
    private LinearLayout voteLayout;

    private String[] candidates = {"Nana Akufo-Addo", "John Mahama", "Ivor Greenstreet", "Akua Donkor"};
    private int[] voteCounts = {0, 0, 0, 0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        titleTextView = findViewById(R.id.titleTextView);
        voteLabel = findViewById(R.id.voteLabel);
        resultTextView = findViewById(R.id.resultTextView);
        winnerTextView = findViewById(R.id.winnerTextView);
        voteButton = findViewById(R.id.voteButton);
        voteLayout = findViewById(R.id.voteLayout);
        candidatesRadioGroup = findViewById(R.id.Candidates);
        final int CANDIDATE1 = R.id.candidate1;
        final int CANDIDATE2 = R.id.candidate2;
        final int CANDIDATE3 = R.id.candidate3;
        final int CANDIDATE4 = R.id.candidate4;


        candidatesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Handle the RadioButton selection here
                if (checkedId == R.id.candidate1) {
                    voteCounts[0] += 1;
                } else if (checkedId == R.id.candidate2) {
                    voteCounts[1] += 1;
                } else if (checkedId == R.id.candidate3) {
                    voteCounts[2] += 1;
                } else if (checkedId == R.id.candidate4) {
                    voteCounts[3] += 1;
                }

            }
        });

        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform vote counting and display results
                Intent intent = new Intent(VotingActivity.this,Results.class);
                startActivity(intent);
            }
        });
    }


}