//Author: Jia Xuan Song
//Course:  SEG2015
//Professor: Timothy Lethbridge

package com.example.assignment5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

//activity for user to choose a difficulty of sudoku they wish to challenge
public class SudokuDifficulty extends AppCompatActivity {

    //creating instance variables and widgets
    RadioGroup choices;
    RadioButton easy, inter, adv;
    Button btn_b, btn_cont;
    int difficulty = 10;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sudoku_diffuculty);

        //linking variables to widgets and buttons
        choices = findViewById(R.id.choices);
        easy = findViewById(R.id.rbEasy);
        inter = findViewById(R.id.rbInter);
        adv = findViewById(R.id.rbAdv);
        btn_b = findViewById(R.id.btn_b);
        btn_cont = findViewById(R.id.btn_cont);
        text = findViewById(R.id.text);

        //choices of the difficulty level are selected
        choices.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbEasy){
                    difficulty = 10;
                }else if(checkedId == R.id.rbInter){
                    difficulty = 25;
                } else {
                    difficulty = 40;
                }
            }
        });
    }

    //onclick method for back button
    public void setBtn_b(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //onclick method for continue button, sends a message to SudokuGame class for the difficulty chosen
    public void setBtn_cont(View view){
        Intent intent = new Intent(this, SudokuGame.class);
        String dif_str = String.valueOf(difficulty);
        intent.putExtra("difficulty", dif_str);
        startActivity(intent);
    }
}
