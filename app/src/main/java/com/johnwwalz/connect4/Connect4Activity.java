package com.johnwwalz.connect4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;v
import android.widget.Toast;

public class Connect4Activity extends AppCompatActivity {
    public TextView message;
    public String[] dictionary = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"};
    public Connect4 game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect4);
        message = (TextView) findViewById(R.id.turn);
        game = new Connect4();
        message.setText("Player 1 is red; Player 2 is blue; Go ahead red!");
    }

    public void buttonPress(View button){
        String tag = button.getTag().toString();
        int slot = Integer.parseInt(tag);
        game.updateGameBoardAt(slot);
        updateUI();
        if(game.isGameOver()){
            playAgain();
        }
    }

    public void updateUI(){
        for(int i = 0; i < dictionary.length; i++){
            int buttonId = getResources().getIdentifier(dictionary[i], "id", getPackageName());
            Button spot = (Button) findViewById(buttonId);
            if(game.gameBoard()[i] == "r"){
                spot.setBackgroundColor(Color.parseColor("red"));
            } else if(game.gameBoard()[i] == "b"){
                spot.setBackgroundColor(Color.parseColor("blue"));
            } else {
                spot.setBackgroundColor(Color.parseColor("white"));
            }
        }
        message.setText("It is " + game.getCurrentTurn() + "'s turn!");
    }

    public void playAgain(){
        Toast.makeText(getApplicationContext(), game.getCurrentTurn() + " wins!", Toast.LENGTH_SHORT).show();
        game = new Connect4();
        updateUI();
    }

    public void playAgain(View button){
        game = new Connect4();
        updateUI();
    }
}