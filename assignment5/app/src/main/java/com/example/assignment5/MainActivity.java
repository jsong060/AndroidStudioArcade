//Author: Jia Xuan Song
//Course:  SEG2015
//Professor: Timothy Lethbridge

package com.example.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

//Main menu of the application
public class MainActivity extends AppCompatActivity {
    //creating buttons
    Button btnTTT, btnSud, btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking buttons to their proper views
        btnSud = findViewById(R.id.btnSud);
        btnTTT = findViewById(R.id.btnTTT);
        btnQuit = findViewById(R.id.btnQuit);

        //onClick method for quit button
        btnQuit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    //onclick methods for btnSud for sudoku game
    public void btnSudClick(View view){
        Intent intent = new Intent(MainActivity.this, SudokuDifficulty.class);
        startActivity(intent);
    }

    //onclick methods for btnTTT for tic tac toe game
    public void btnTTTClick(View view){
        Intent intent = new Intent(MainActivity.this, Tictactoe.class);
        startActivity(intent);
    }

}