package com.cflower6.connect3;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;


public class MainActivity extends AppCompatActivity {

    int playerTurn = 0;
    int win = 0;
    boolean winner = false;
    int[][] gameboard = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public void pick(View view) {

        ImageView counter = (ImageView) view;

        int tapped = Integer.parseInt(counter.getTag().toString());

        if(playerTurn == 0){
            if(tapped > 2 && tapped < 6){
                tapped -= 3;
                if(gameboard[1][tapped] == 0){
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.red);
                    gameboard[1][tapped] = 1;
                }else{
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            }else if(tapped >= 6){
                tapped -= 6;
                if(gameboard[2][tapped] == 0){
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.red);
                    gameboard[2][tapped] = 1;
                }else{
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            }else{
                if(gameboard[0][tapped] == 0){
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.red);
                    gameboard[0][tapped] = 1;
                }else{
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            }
            int r = row(gameboard, playerTurn);
            int c = col(gameboard, playerTurn);
            int d = dia(gameboard, playerTurn);

            if(r == 1 || c == 1 || d == 1){
                winner = true;
            }
            playerTurn += 1;

        }else{
            if(tapped > 2 && tapped < 6){
                tapped -= 3;
                if(gameboard[1][tapped] == 0){
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.yellow);
                    gameboard[1][tapped] = 2;
                }else{
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            }else if(tapped >= 6){
                tapped -= 6;
                if(gameboard[2][tapped] == 0){
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.yellow);
                    gameboard[2][tapped] = 2;
                }else{
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            }else{
                if(gameboard[0][tapped] == 0){
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.yellow);
                    gameboard[0][tapped] = 2;
                }else{
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            }
            int r = row(gameboard, playerTurn);
            int c = col(gameboard, playerTurn);
            int d = dia(gameboard, playerTurn);

            if(r == 1 || c == 1 || d == 1){
                winner = true;
            }
                playerTurn -= 1;
        }
        if(winner){
            Toast.makeText(MainActivity.this, "WINNER", Toast.LENGTH_LONG).show();
        }

    }

    public int row(int[][] gameboard, int player){
        int winner = 0;
        int i = 0;
        int j = 0;
        while(j < 3){
            if(gameboard[i][j] == player){
                winner = player;
            }else{
                winner = 0;
            }
            j++;
        }
        return winner;
    }

    public int col(int[][] gameboard, int player){
        int winner = 0;
        int i = 0;
        int j = 0;
        while(i < 3){
            if(gameboard[i][j] == player){
                winner = player;
            }else{
                winner = 0;
            }
            i++;
        }

        return winner;
    }

    public int dia(int[][] gameboard, int player){
        int winner = 0;
        int i = 0;
        int j = 0;
        while(i < 3){
            if (gameboard[i][j] == player){
                winner = player;
            }else{
                winner = 0;
            }
            i++;
            j++;
        }
        return winner;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView player2 = (TextView) findViewById(R.id.Player2);
        player2.animate().alpha(0f).setDuration(100);
    }
}
