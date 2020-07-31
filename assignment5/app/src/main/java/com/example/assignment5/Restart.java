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

        textRestart.setText(msg);

    }

    public void btnMenuClick(View view){
        Intent intent = new Intent(this, Tictactoe.class);
        startActivity(intent);
    }

    public void btnRestartClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
