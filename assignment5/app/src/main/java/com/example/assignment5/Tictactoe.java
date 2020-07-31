package com.example.assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tictactoe extends AppCompatActivity{
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn_back;
    TextView text_player1;
    TextView text_player2;

    boolean p1turn = true;
    int count = 0;
    int p1win = 0;
    int p2win = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn_back = findViewById(R.id.btn_back);
        text_player1 = findViewById(R.id.text_player1);
        text_player2 = findViewById(R.id.text_player2);

        text_player1.setText("Player 1: " + p1win);
        text_player2.setText("Player 2: " + p2win);
    }


    public void btnBackOnClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void gameBtnOnClick(View v){
        if(!(((Button) v).getText().toString().equals("X") || ((Button) v).getText().toString().equals("O"))){
            if(p1turn){
                ((Button) v).setText("X");
            }else{
                ((Button) v).setText("O");
            }

            count++;

            if(check()){
                if(p1turn) {
                    //player 1 wins
                    Toast.makeText(this, "player1 win", Toast.LENGTH_SHORT).show();
                    p1win++;
                    updateScore();
                }else{
                    //player 2 wins
                    Toast.makeText(this, "player2 win", Toast.LENGTH_SHORT).show();
                    p2win++;
                    updateScore();

                }
            }else if(count == 9){
                Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
                updateScore();
            }else{
                p1turn = !p1turn;
            }
        }
    }
    public void updateScore(){
        text_player1.setText("Player 1: " + p1win);
        text_player2.setText("Player 2: " + p2win);
        if(p1win < 2 && p2win < 2){
            reset();
        }
        else{
            if(p1win >= 2){
                proceed("p1win");
            }else {
                proceed("p2win");
            }
        }
    }

    public void proceed(String msg){
        Intent intent = new Intent(this, Restart.class);
        intent.putExtra("msg", msg);
        startActivity(intent);
    }

    public boolean check(){
        String[][] board = new String[3][3];
        //check win condition for 3 columns
        if(btn0.getText().toString().equals(btn3.getText().toString())
                && btn0.getText().toString().equals(btn6.getText().toString())
                && !btn0.getText().toString().equals("")){
                return true;
        }
        if(btn1.getText().toString().equals(btn4.getText().toString())
                && btn1.getText().toString().equals(btn7.getText().toString())
                && !btn1.getText().toString().equals("")){
            return true;
        }
        if(btn2.getText().toString().equals(btn5.getText().toString())
                && btn2.getText().toString().equals(btn8.getText().toString())
                && !btn2.getText().toString().equals("")){
            return true;
        }

        //check win condition for 3 rows
        if(btn0.getText().toString().equals(btn1.getText().toString())
                && btn0.getText().toString().equals(btn2.getText().toString())
                && !btn0.getText().toString().equals("")){
            return true;
        }
        if(btn3.getText().toString().equals(btn4.getText().toString())
                && btn3.getText().toString().equals(btn5.getText().toString())
                && !btn3.getText().toString().equals("")){
            return true;
        }
        if(btn6.getText().toString().equals(btn7.getText().toString())
                && btn6.getText().toString().equals(btn8.getText().toString())
                && !btn6.getText().toString().equals("")){
            return true;
        }

        return false;
    }

    public void reset(){
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        p1turn = true;
        count = 0;
    }
}
