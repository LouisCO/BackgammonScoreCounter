package com.example.android.backgammonscorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Tracks the score for Black
    int scoreBlack=0;
    // Tracks the score for White
    int scoreWhite=0;
    //Strings for retrieving counters after rotation
    String mScoreBlack="scoreBlack";
    String mScoreWhite="scoreWhite";
    TextView blScoreView;
    TextView whScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blScoreView=findViewById(R.id.bl_score);
        whScoreView=findViewById(R.id.wh_score);
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(mScoreBlack, scoreBlack);
        savedInstanceState.putInt(mScoreWhite, scoreWhite);


        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreBlack=savedInstanceState.getInt(mScoreBlack);
        scoreWhite=savedInstanceState.getInt(mScoreWhite);
        displayScoreForBlack(scoreBlack);
        displayScoreForWhite(scoreWhite);
    }

    //Increase score for Black with 1 point
    public void addOneForBlack(View v) {
        scoreBlack++;
        displayScoreForBlack(scoreBlack);
    }

    //Increase score for Black with 2 points
    public void addTwoForBlack(View v) {
        scoreBlack+=2;
        displayScoreForBlack(scoreBlack);
    }

    //Increase score for Black with 3 points
    public void addThreeForBlack(View v) {
        scoreBlack+=3;
        displayScoreForBlack(scoreBlack);
    }

    //Increase score for White with 1 point
    public void addOneForWhite(View v) {
        scoreWhite++;
        displayScoreForWhite(scoreWhite);
    }

    //Increase score for White with 2 points
    public void addTwoForWhite(View v) {
        scoreWhite+=2;
        displayScoreForWhite(scoreWhite);
    }

    //Increase score for White with 3 points
    public void addThreeForWhite(View v) {
        scoreWhite+=3;
        displayScoreForWhite(scoreWhite);
    }

    //Displays score for Black
    public void displayScoreForBlack(int scoreBlack) {
        blScoreView.setText(String.valueOf(scoreBlack));
    }

    //Displays score for White
    public void displayScoreForWhite(int scoreWhite) {
        whScoreView.setText(String.valueOf(scoreWhite));
    }

    //Resets score to 0
    public void resetScore(View v) {
        Intent MainActivity=getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        assert MainActivity != null;
        MainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(MainActivity);
    }

}
