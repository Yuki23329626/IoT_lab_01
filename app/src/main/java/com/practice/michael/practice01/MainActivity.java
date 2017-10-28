package com.practice.michael.practice01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MainActivity";

    TextView tv_title;
    TextView tv_result;
    EditText editText;

    Button btnGuess;
    Button btnAbout;
    Button btnRestart;
    Button btnQuit;

    TextView tv_about;

    Random r = new Random();
    int target = 0;
    int count = 1;
    int lowerBound = 1;
    int upperBound = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        target = (r.nextInt(100) + 1 );

        tv_title = findViewById(R.id.title);
        tv_result = findViewById(R.id.tv_result);
        editText = findViewById(R.id.editText);
        tv_about = findViewById(R.id.tv_about);

        btnGuess = findViewById(R.id.buttonGuess);
        btnGuess.setOnClickListener(btnGuessClick);

        btnAbout = findViewById(R.id.buttonAbout);
        btnAbout.setOnClickListener(btnAboutClick);

        btnRestart = findViewById(R.id.buttonRestart);
        btnRestart.setOnClickListener(btnRestartClick);

        btnQuit = findViewById(R.id.buttonQuit);
        btnQuit.setOnClickListener(btnQuitClick);
    }

    Button.OnClickListener btnGuessClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                int guess = Integer.parseInt(editText.getText().toString());
                if(0 < guess && guess <= 100){
                    if(guess == target){
                        tv_result.setText("Correct!");
                    }
                    else if(guess > target){
                        tv_result.setText("Your guess is too high.\nWrong guess:" + Integer.toString(count++));
                        upperBound = guess;
                        tv_title.setText("Enter a number between " + lowerBound + " to " + upperBound);
                    }
                    else if(guess < target){
                        tv_result.setText("Your guess is too low.\nWrong guess:" + Integer.toString(count++));
                        lowerBound = guess;
                        tv_title.setText("Enter a number between " + lowerBound + " to " + upperBound);
                    }
                }
                else {
                    tv_result.setText("Please enter a number from 1 to 100!");
                }
            } catch (NumberFormatException e) {
                tv_result.setText("It is not a number!");
            }
        }
    };

    Button.OnClickListener btnAboutClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            tv_about.setText("This is about.\nCCU CSIE\n403410016\n沈濃翔");
        }
    };

    Button.OnClickListener btnRestartClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            target = (r.nextInt(100) );
            count = 1;
            tv_result.setText("Reset!");
        }
    };

    Button.OnClickListener btnQuitClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    };
}
