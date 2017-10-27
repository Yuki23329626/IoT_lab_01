package com.practice.michael.practice01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_title;
    EditText editText;

    Button btnGuess;
    Button btnAbout;
    Button btnRestart;
    Button btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_title = findViewById(R.id.title);
        editText = findViewById(R.id.editText);

        btnGuess = findViewById(R.id.buttonGuess);
        btnAbout = findViewById(R.id.buttonAbout);
        btnRestart = findViewById(R.id.buttonRestart);
        btnQuit = findViewById(R.id.buttonQuit);
    }
}
