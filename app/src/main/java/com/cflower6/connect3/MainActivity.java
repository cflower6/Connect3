package com.cflower6.connect3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
    [0][1][2] winner = {0,1,2}, {3,4,5}, {6,7,8},{0,3,6}, {1, 4, 7}, {2, 5, 8},{0,4,8}, {2,4,6}
    [3][4][5]
    [6][7][8]
    */

    public void GamePieces(View view){

        ImageView red1 = (ImageView) findViewById(R.id.POneRed);
        ImageView red2 = (ImageView) findViewById(R.id.POneRed2);
        ImageView red3 = (ImageView) findViewById(R.id.POneRed3);
        ImageView red4 = (ImageView) findViewById(R.id.POneRed4);
        ImageView red5 = (ImageView) findViewById(R.id.POneRed5);
        ImageView red6 = (ImageView) findViewById(R.id.POneRed6);
        ImageView red7 = (ImageView) findViewById(R.id.POneRed7);
        ImageView red8 = (ImageView) findViewById(R.id.POneRed8);
        ImageView red9 = (ImageView) findViewById(R.id.POneRed9);

        ImageView yellow1 = (ImageView) findViewById(R.id.PTwoYellow);
        ImageView yellow2 = (ImageView) findViewById(R.id.PTwoYellow2);
        ImageView yellow3 = (ImageView) findViewById(R.id.PTwoYellow3);
        ImageView yellow4 = (ImageView) findViewById(R.id.PTwoYellow4);
        ImageView yellow5 = (ImageView) findViewById(R.id.PTwoYellow5);
        ImageView yellow6 = (ImageView) findViewById(R.id.PTwoYellow6);
        ImageView yellow7 = (ImageView) findViewById(R.id.PTwoYellow7);
        ImageView yellow8 = (ImageView) findViewById(R.id.PTwoYellow8);
        ImageView yellow9 = (ImageView) findViewById(R.id.PTwoYellow9);



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
