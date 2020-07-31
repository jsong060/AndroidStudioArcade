//Author: Jia Xuan Song
//Course:  SEG2015
//Professor: Timothy Lethbridge

package com.example.assignment5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Restart extends AppCompatActivity {
    Button btnRestart, btnMenu;
    TextView textRestart;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        msg = intent.getExtras().getString("msg");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restart);

        btnRestart = findViewById(R.id.btnRestart);
        btnMenu = findViewById(R.id.btnMenu);
        textRestart = findViewById(R.id.textRestart);

        if(msg.equals("p1win")){
            textRestart.setText("Congratulation, player 1 wins!");
        }else if(msg.equals("p2win")){
            textRestart.setText("Congratulation, player 2 wins!");
        }else{
            textRestart.setText("Congratulation, you solved the Sudoku puzzle!");
        }


    }

    public void btnMenuClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnRestartClick(View view){
        if(msg.equals("p1win")||msg.equals("p2win")){
            Intent intent = new Intent(this, Tictactoe.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, SudokuDifficulty.class);
            startActivity(intent);
        }

    }
}
