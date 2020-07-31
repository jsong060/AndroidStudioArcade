//Author: Jia Xuan Song
//Course:  SEG2015
//Professor: Timothy Lethbridge

package com.example.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SudokuGame extends AppCompatActivity {
    EditText[][] editTexts = new EditText[9][9];
    String[][] compare = new String[9][9];

    Button btn_b1, btn_hint, btn_solve;
    Sudoku board;
    int difficulty;
    TextView textViewTitle;

    Random rand = new Random();
    boolean solved = true;
    int zeroCount = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        difficulty = Integer.parseInt(intent.getExtras().getString("difficulty"));
        //zeroCount = difficulty;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sudoku_game);


        textViewTitle = findViewById(R.id.TextViewTitle);
        btn_b1 = findViewById(R.id.btn_b1);
        btn_hint = findViewById(R.id.btn_hint);
        btn_solve = findViewById(R.id.btn_solve);

        board = new Sudoku(9, 0);
        board.fillValues();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String editTextID = "editText" + i + j;
                int resID = getResources().getIdentifier(editTextID, "id", getPackageName());
                editTexts[i][j] = (EditText) findViewById(resID);
                editTexts[i][j].setText(String.valueOf(board.mat[i][j]));


            }
        }
        deleteNumbers();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                compare[i][j] = editTexts[i][j].getText().toString();
                if (compare[i][j].equals("")) {
                    compare[i][j] = "0";
                }

                if (!editTexts[i][j].getText().toString().equals("")) {
                    editTexts[i][j].setKeyListener(null);
                    editTexts[i][j].setInputType(InputType.TYPE_NULL);
                    editTexts[i][j].setTextIsSelectable(false);
                    editTexts[i][j].setFocusable(false);
                }
            }
        }
    }

    public void deleteNumbers() {
        while (difficulty > 0) {
            int r_row = rand.nextInt(9);
            int r_col = rand.nextInt(9);

            if (!editTexts[r_row][r_col].getText().toString().equals("")) {
                editTexts[r_row][r_col].setText("");
                difficulty--;
            }
        }
    }

    public void update() {
        zeroCount = 0;
        solved = true;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Integer.parseInt(compare[i][j]) == 0) {
                    zeroCount++;
                }
                if (Integer.parseInt(compare[i][j]) != board.mat[i][j]) {
                    solved = false;
                }
            }
        }
    }

    public void setBtn_b1(View view) {
        Intent intent = new Intent(this, SudokuDifficulty.class);
        startActivity(intent);
    }

    public void setBtn_hint(View view) { //////////////////////////nneed fix, completed puzzle and then click
        while (true && zeroCount != 0) {
            int i = rand.nextInt(9);
            int j = rand.nextInt(9);

            if (board.mat[i][j] != Integer.parseInt(compare[i][j])) {
                editTexts[i][j].setText(String.valueOf(board.mat[i][j]));
                compare[i][j] = String.valueOf(board.mat[i][j]);
                //Toast.makeText(this, "Hint given", Toast.LENGTH_SHORT).show();
                break;
            }
            update();

        }
    }

    public void setBtn_solve(View view) {
        update();
        if (solved && (zeroCount == 0)) {
            Toast.makeText(this, "Solved", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Restart.class);
            intent.putExtra("msg", "sudoku");
            startActivity(intent);
        } else {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}


