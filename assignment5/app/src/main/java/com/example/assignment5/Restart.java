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

//transitional activity that prints a special message depending on where the user's last visited activity
public class Restart extends AppCompatActivity {
    //creating instances of widgets that were used, as well as other useful variables
    Button btnRestart, btnMenu;
    TextView textRestart;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getting the message sent from previous activity and set the default view to restart.xml
        Intent intent = getIntent();
        msg = intent.getExtras().getString("msg");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restart);

        //linking buttons and other widgets
        btnRestart = findViewById(R.id.btnRestart);
        btnMenu = findViewById(R.id.btnMenu);
        textRestart = findViewById(R.id.textRestart);

        //change the text message depending on the last activity
        if(msg.equals("p1win")){
            textRestart.setText("Congratulation, player 1 wins!");
        }else if(msg.equals("p2win")){
            textRestart.setText("Congratulation, player 2 wins!");
        }else{
            textRestart.setText("Congratulation, you solved the Sudoku puzzle!");
        }


    }

    //onclick method for btnMenu
    public void btnMenuClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //onclick method for btnRestart
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
