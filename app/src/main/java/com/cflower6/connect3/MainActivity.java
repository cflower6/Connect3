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
    boolean gameActive = true;
    int gameTurn = 0;
    int[] gameState = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[][] gameWin = {{0,1,2},{3,4,5},{6,7,8}, {0,3,6},{1,4,7},{2,5,8}, {0,4,8},{2,4,6}};

    public void pick(View view) {

        ImageView counter = (ImageView) view;

        int tapped = Integer.parseInt(counter.getTag().toString());
        if(gameActive) {
            if (gameState[tapped] == -1) {
                gameState[tapped] = playerTurn;
                if (playerTurn == 0) {
                    playerTurn += 1;
                    gameTurn += 1;
                    TextView player1 = findViewById(R.id.Player1);
                    TextView player2 = findViewById(R.id.Player2);

                    counter.setImageResource(R.drawable.red);

                    player1.animate().alpha(1f);
                    player2.animate().alpha(0f);
                } else {
                    playerTurn -= 1;
                    gameTurn += 1;
                    TextView player1 = findViewById(R.id.Player1);
                    TextView player2 = findViewById(R.id.Player2);

                    counter.setImageResource(R.drawable.yellow);

                    player1.animate().alpha(0f);
                    player2.animate().alpha(1f);
                }
            }
        }

        if(findWinner(gameState,gameWin) > -1) {
            gameActive = false;
            if (findWinner(gameState, gameWin) == 0) {
                TextView win1Message = findViewById(R.id.winMessageP1);
                win1Message.animate().alpha(1f);
            } else {
                TextView win2Message = findViewById(R.id.winMessageP2);
                win2Message.animate().alpha(1f);
            }

            Button playAgain = findViewById(R.id.playBtn);
            playAgain.setVisibility(View.VISIBLE);
        }

        if(findWinner(gameState, gameWin) < 0 && gameTurn == 9){
            TextView drawMessage = findViewById(R.id.drawMessage);
            drawMessage.animate().alpha(1f);
            gameActive = false;
            Button playAgain = findViewById(R.id.playBtn);
            playAgain.setVisibility(View.VISIBLE);
        }

    }

    public int findWinner(int[] gameState, int[][] gameWin){
        int playerThatWon = -1;

        for(int[] g : gameWin){
            if(gameState[g[0]] == gameState[g[1]] && gameState[g[1]] == gameState[g[2]] && gameState[g[0]] != -1){
                playerThatWon = gameState[g[0]];
            }
        }
        return playerThatWon;
    }



    public void playAgain (View view){
        Button btn = findViewById(R.id.playBtn);
        btn.setVisibility(View.INVISIBLE);
        gameActive = true;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = -1;

        }

        TableRow ind1 = findViewById(R.id.index0);
        TableRow ind2 = findViewById(R.id.index1);
        TableRow ind3 = findViewById(R.id.index2);
        for (int i = 0; i < ind1.getChildCount(); i++) {
            ((ImageView) ind1.getChildAt(i)).setImageResource(0);
        }
        for (int i = 0; i < ind2.getChildCount(); i++) {
            ((ImageView) ind2.getChildAt(i)).setImageResource(0);
        }
        for (int i = 0; i < ind3.getChildCount(); i++) {
            ((ImageView) ind3.getChildAt(i)).setImageResource(0);
        }

        TextView winnerMessage = findViewById(R.id.winMessageP1);
        TextView winnerMessage2 = findViewById(R.id.winMessageP2);
        TextView drawMessage = findViewById(R.id.drawMessage);
        drawMessage.animate().alpha(0f);
        winnerMessage.animate().alpha(1f);
        winnerMessage2.animate().alpha(0f);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
