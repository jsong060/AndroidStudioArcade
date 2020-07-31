//Author: Jia Xuan Song
//Course:  SEG2015
//Professor: Timothy Lethbridge

package com.example.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Button btnTTT, btnSud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSud = findViewById(R.id.btnSud);
        btnTTT = findViewById(R.id.btnTTT);

    }

    public void btnSudClick(View view){
        Intent intent = new Intent(MainActivity.this, Sudoku.class);
        startActivity(intent);
    }

    public void btnTTTClick(View view){
        Intent intent = new Intent(MainActivity.this, Tictactoe.class);
        startActivity(intent);
    }
}