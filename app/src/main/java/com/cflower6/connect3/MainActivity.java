package com.cflower6.connect3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    /*                     7        12      21      9          12       15         12
    [0][1][2] winner = {0,1,2}, {3,4,5}, {6,7,8},{0,3,6}, {1, 4, 7}, {2, 5, 8},{0,4,8}, {2,4,6}
    [3][4][5]
    [6][7][8]
    */
//    int position = 0;
////    public void GamePieces(View view){
////        int[][] gameBoard = new int[3][3];
////        boolean isWin = false;
////
////        TextView player1 = (TextView) findViewById(R.id.Player1);
////        TextView player2 = (TextView) findViewById(R.id.Player2);
////
////        ImageView red1 = (ImageView) findViewById(R.id.POneRed);
////        ImageView red2 = (ImageView) findViewById(R.id.POneRed2);
////        ImageView red3 = (ImageView) findViewById(R.id.POneRed3);
////        ImageView red4 = (ImageView) findViewById(R.id.POneRed4);
////        ImageView red5 = (ImageView) findViewById(R.id.POneRed5);
////        ImageView red6 = (ImageView) findViewById(R.id.POneRed6);
////        ImageView red7 = (ImageView) findViewById(R.id.POneRed7);
////        ImageView red8 = (ImageView) findViewById(R.id.POneRed8);
////        ImageView red9 = (ImageView) findViewById(R.id.POneRed9);
////
////        ImageView yellow1 = (ImageView) findViewById(R.id.PTwoYellow);
////        ImageView yellow2 = (ImageView) findViewById(R.id.PTwoYellow2);
////        ImageView yellow3 = (ImageView) findViewById(R.id.PTwoYellow3);
////        ImageView yellow4 = (ImageView) findViewById(R.id.PTwoYellow4);
////        ImageView yellow5 = (ImageView) findViewById(R.id.PTwoYellow5);
////        ImageView yellow6 = (ImageView) findViewById(R.id.PTwoYellow6);
////        ImageView yellow7 = (ImageView) findViewById(R.id.PTwoYellow7);
////        ImageView yellow8 = (ImageView) findViewById(R.id.PTwoYellow8);
////        ImageView yellow9 = (ImageView) findViewById(R.id.PTwoYellow9);
////
////        int player1turn = 0;
////        int player2turn = 0;
////
////           /*                     7        12      21      9          12       15         12
////    [0][1][2] winner = {0,1,2}, {3,4,5}, {6,7,8},{0,3,6}, {1, 4, 7}, {2, 5, 8},{0,4,8}, {2,4,6}
////    [3][4][5]
////    [6][7][8]
////    */
////        while(isWin != true) {
////            if (player1turn == player2turn) {
////                player2.animate().alpha(0).setDuration(100);
////
////                if(position == 1){
////                    red1.animate().alpha(1f).setDuration(100);
////                }else if(position == 2){
////                    red2.animate().alpha(1f).setDuration(100);
////                }else if(position == 3){
////                    red3.animate().alpha(1f).setDuration(100);
////                }else if(position == 4){
////                    red4.animate().alpha(1f).setDuration(100);
////                }else if(position == 5){
////                    red5.animate().alpha(1f).setDuration(100);
////                }else if(position == 6){
////                    red6.animate().alpha(1f).setDuration(100);
////                }else if(position == 7){
////                    red7.animate().alpha(1f).setDuration(100);
////                }else if(position == 8){
////                    red8.animate().alpha(1f).setDuration(100);
////                }else{
////                    red9.animate().alpha(1f).setDuration(100);
////                }
////                if (position > 3 && position < 7) {
////                    int numHold = position % 3;
////                    gameBoard[1][numHold] = 1;
////                } else if (position > 6) {
////                    int numHold = position % 6;
////                    gameBoard[2][numHold] = 1;
////                } else {
////                    gameBoard[0][position] = 1;
////                }
////
////                int i = row(gameBoard);
////                int j = col(gameBoard);
////                int x = dia(gameBoard);
////
////                if(i == 1 || j == 1 || x == 1){
////                    isWin = true;
////                }
////                if(isWin){
////                    TextView winMessage = (TextView) findViewById(R.id.win1message);
////                    winMessage.animate().alpha(1);
////                }
////
////            } else {
////                player2.animate().alpha(1f).setDuration(100);
////                player1.animate().alpha(0f).setDuration(100);
////
////                if(position == 1){
////                    yellow1.animate().alpha(1f).setDuration(100);
////                }else if(position == 2){
////                    yellow2.animate().alpha(1f).setDuration(100);
////                }else if(position == 3){
////                    yellow3.animate().alpha(1f).setDuration(100);
////                }else if(position == 4){
////                    yellow4.animate().alpha(1f).setDuration(100);
////                }else if(position == 5){
////                    yellow5.animate().alpha(1f).setDuration(100);
////                }else if(position == 6){
////                    yellow6.animate().alpha(1f).setDuration(100);
////                }else if(position == 7){
////                    yellow7.animate().alpha(1f).setDuration(100);
////                }else if(position == 8){
////                    yellow8.animate().alpha(1f).setDuration(100);
////                }else{
////                    yellow9.animate().alpha(1f).setDuration(100);
////                }
////
////                if (position > 3 && position < 7) {
////                    int numHold = position % 3;
////                    gameBoard[1][numHold] = 2;
////                } else if (position > 6) {
////                    int numHold = position % 6;
////                    gameBoard[2][numHold] = 2;
////                } else {
////                    gameBoard[0][position] = 2;
////                }
////
////                int i = row(gameBoard);
////                int j = col(gameBoard);
////                int x = dia(gameBoard);
////
////                if(i == 1 || j == 1 || x == 1){
////                    isWin = true;
////                }
////                if(isWin){
////                    TextView winMessage = (TextView) findViewById(R.id.win2message);
////                    winMessage.animate().alpha(1f);
////                }
////            }
////
////        }
////
////    }
////
////    public int dia(int[][] gameboard){
////        int player = 0;
////
////        int i = 0;
////        int j = 0;
////
////        while(i < 3){
////            if(gameboard[i][j] == 1){
////                player = 1;
////            }else if(gameboard[i][j] == 2){
////                player = 2;
////            }else{
////                player = 0;
////                break;
////            }
////            i++;
////            j++;
////        }
////        return player;
////    }
////
////    public int row(int[][] gameboard){
////        int player = 0;
////
////        int i = 0;
////        int j = 0;
////        while(j < 3){
////            if(gameboard[i][j] == 1 ){
////                player = 1;
////            }else if(gameboard[i][j] == 2){
////                player = 2;
////            }else{
////                player = 0;
////                return player;
////            }
////
////            j++;
////        }
////        return player;
////    }
////
////    public int col(int[][] gameboard){
////        int player = 0;
////
////        int i = 0;
////        int j = 0;
////        while(i < 3){
////            if(gameboard[i][j] == 1){
////                player = 1;
////            }else if(gameboard[i][j] == 2){
////                player = 2;
////            }else{
////                player = 0;
////                return player;
////            }
////        }
////        return player;
////    }
////    public void onClick(View view)
////    {
////        switch (view.getId()) {
////            case R.id.POneRed:
////                position = 1;
////            case R.id.POneRed2:
////                position = 2;
////            case R.id.POneRed3:
////                position = 3;
////            case R.id.POneRed4:
////                position = 4;
////            case R.id.POneRed5:
////                position = 5;
////            case R.id.POneRed6:
////                position = 6;
////            case R.id.POneRed7:
////                position =  7;
////            case R.id.POneRed8:
////                position = 8;
////            case R.id.POneRed9:
////                position = 9;
////        }
////    }
int play1 = 0;
int play2 = 0;
public void pick(View view){
    ImageView counter = (ImageView) view;

    if(play1 == play2){
        counter.setImageResource(R.drawable.red);
        play1++;
        TextView player1 = findViewById(R.id.Player1);
        TextView player2 = findViewById(R.id.Player2);
        player1.animate().alpha(0f).setDuration(100);
        player2.animate().alpha(1f).setDuration(100);
    }else{
        counter.setImageResource(R.drawable.yellow);
        play2++;
        TextView player1 = findViewById(R.id.Player1);
        TextView player2 = findViewById(R.id.Player2);
        player1.animate().alpha(1f).setDuration(100);
        player2.animate().alpha(0f).setDuration(100);
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView player2 = (TextView) findViewById(R.id.Player2);
        player2.animate().alpha(0f).setDuration(100);
    }
}
