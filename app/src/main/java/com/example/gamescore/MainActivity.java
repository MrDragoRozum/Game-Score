package com.example.gamescore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;

    private TextView textViewScore1;
    private TextView textViewScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate() created!");

        if(savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }

        textViewScore1 = findViewById(R.id.textViewScore1);
        textViewScore2 = findViewById(R.id.textViewScore2);

        updateScore1(0);
        updateScore2(0);

        textViewScore1.setOnClickListener(l -> {
            updateScore1(1);
            Log.d("MainActivity", "Clicked textViewScore1");
        });

        textViewScore2.setOnClickListener(l -> {
            updateScore2(1);
            Log.d("MainActivity", "Clicked textViewScore2");
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart started!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop stopped!");
    }

    private void updateScore1(int updateScore) {
        if(updateScore == 1) score1++;
        textViewScore1.setText(String.valueOf(score1));
    }

    private void updateScore2(int updateScore) {
        if(updateScore == 1) score2++;
        textViewScore2.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);

        Log.d("MainActivity", "onSaveInstanceState() saved!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy() destroyed this activity!");
    }
}