package com.cflower6.connect3;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    int playerTurn = 0;
    int roundCount = 0;
    boolean winner = false;
    int[][] gameboard = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public void pick(View view) {

        ImageView counter = (ImageView) view;

        int tapped = Integer.parseInt(counter.getTag().toString());


        if (playerTurn == 0) {
            roundCount += 1;

            TextView player1 =  findViewById(R.id.Player1);
            TextView player2 =  findViewById(R.id.Player2);
            player1.animate().alpha(1f).setDuration(100);
            player2.animate().alpha(0f).setDuration(100);

            if (tapped > 2 && tapped < 6) {
                tapped -= 3;
                if (gameboard[1][tapped] == 0) {
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.red);
                    gameboard[1][tapped] = 1;
                } else {
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            } else if (tapped >= 6) {
                tapped -= 6;
                if (gameboard[2][tapped] == 0) {
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.red);
                    gameboard[2][tapped] = 1;
                } else {
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            } else {
                if (gameboard[0][tapped] == 0) {
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.red);
                    gameboard[0][tapped] = 1;
                } else {
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            }

            int r = row(gameboard, 1);
            int c = col(gameboard, 1);
            int d = dia(gameboard, 1);

            if (r == 1 || c == 1 || d == 1) {
                TextView winnerMessage = findViewById(R.id.winMessageP1);
                winnerMessage.animate().alpha(1f);
                winner = true;
            }

            if(winner == true){
                Button playAgainBtn = findViewById(R.id.playBtn);
                playAgainBtn.setVisibility(View.VISIBLE);
            }
            playerTurn += 1;

        } else {
            roundCount += 1;

            TextView player1 =  findViewById(R.id.Player1);
            TextView player2 =  findViewById(R.id.Player2);
            player1.animate().alpha(0f).setDuration(100);
            player2.animate().alpha(1f).setDuration(100);

            if (tapped > 2 && tapped < 6) {
                tapped -= 3;
                if (gameboard[1][tapped] == 0) {
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.yellow);
                    gameboard[1][tapped] = 2;
                } else {
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            } else if (tapped >= 6) {
                tapped -= 6;
                if (gameboard[2][tapped] == 0) {
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.yellow);
                    gameboard[2][tapped] = 2;
                } else {
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            } else {
                if (gameboard[0][tapped] == 0) {
                    ImageView RToken = (ImageView) view;
                    RToken.setImageResource(R.drawable.yellow);
                    gameboard[0][tapped] = 2;
                } else {
                    Toast.makeText(MainActivity.this, "Can't do that", Toast.LENGTH_LONG).show();
                }
            }

            int r = row(gameboard, 2);
            int c = col(gameboard, 2);
            int d = dia(gameboard, 2);

            if (r == 2 || c == 2 || d == 2) {
                TextView winnerMessage2 = findViewById(R.id.winMessageP2);
                winnerMessage2.animate().alpha(1f);
                winner = true;
            }
            if(winner){
                Button playAgainBtn = findViewById(R.id.playBtn);
                playAgainBtn.setVisibility(View.VISIBLE);
            }
            playerTurn -= 1;
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
                return winner;
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
                return winner;
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
                return winner;
            }
            i++;
            j++;
        }
        return winner;
    }

    public void playAgain(View view){
        Button btn = findViewById(R.id.playBtn);
        btn.setVisibility(View.INVISIBLE);
        for(int i = 0; i < gameboard.length; i++){
            for(int j = 0; j < gameboard[i].length; j++){
                gameboard[i][j] = 0;
            }
        }

        TableRow ind1 = findViewById(R.id.index0);
        TableRow ind2 = findViewById(R.id.index1);
        TableRow ind3 = findViewById(R.id.index2);
        for(int i = 0; i < ind1.getChildCount(); i++){
            ((ImageView) ind1.getChildAt(i)).setImageResource(0);
        }
        for(int i = 0; i < ind2.getChildCount(); i++){
            ((ImageView) ind2.getChildAt(i)).setImageResource(0);
        }
        for(int i = 0; i < ind3.getChildCount(); i++){
            ((ImageView) ind3.getChildAt(i)).setImageResource(0);
        }

        TextView winnerMessage = findViewById(R.id.winMessageP1);
        TextView winnerMessage2 = findViewById(R.id.winMessageP2);
        winnerMessage.animate().alpha(0f);
        winnerMessage2.animate().alpha(0f);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
