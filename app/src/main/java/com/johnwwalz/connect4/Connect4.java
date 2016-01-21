package com.johnwwalz.connect4;

/**
 * Created by john on 1/18/2016.
 */
public class Connect4{
    private String[] gameBoard2 = { "_","_","_","_","_","_","_",
                                    "_","_","_","_","_","_","_",
                                    "_","_","_","_","_","_","_",
                                    "_","_","_","_","_","_","_",
                                    "_","_","_","_","_","_","_",
                                    "_","_","_","_","_","_","_" };
    private boolean gameOver;
    private String currentTurn;

    public boolean isGameOver(){
        return gameOver;
    }

    public Connect4() {
        gameOver = false;
        currentTurn = "Red";
    }

    public String[] gameBoard(){
        return gameBoard2;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public void updateGameBoardAt(int slot) {
        if(currentTurn == "Red") {
            for(int i = slot - 1 + 35; i > (slot - 2); i -= 7){
                if(gameBoard2[i] == "_"){
                    gameBoard2[i] = "r";
                    break;
                }
            }
            currentTurn = "Blue";
            checkGame();
        } else {
            for(int i = slot - 1 + 35; i > (slot - 2); i -= 7){
                if(gameBoard2[i] == "_"){
                    gameBoard2[i] = "b";
                    break;
                }
            }
            currentTurn = "Red";
            checkGame();
        }
    }

    public void checkGame() {
        checkColumns();
        checkRows();
        checkDiagonals();
    }
    public void checkColumns(){
        for(int i = 0; i < 7; i++){
            for(int j = 0 + i; j < i + 15; j += 7){
                if(gameBoard2[j] == "r" && gameBoard2[j + 7] == "r" && gameBoard2[j + 14] == "r" && gameBoard2[j + 21] == "r"){
                    gameOver = true;
                    currentTurn = "Red";
                } else if(gameBoard2[j] == "b" && gameBoard2[j + 7] == "b" && gameBoard2[j + 14] == "b" && gameBoard2[j + 21] == "b"){
                    gameOver = true;
                    currentTurn = "Blue";
                }
            }
        }
    }

    public void checkRows(){
        for(int i = 0; i < 36; i += 7){
            for(int j = i; j < i + 4; j++){
                if(gameBoard2[j] == "r" && gameBoard2[j + 1] == "r" && gameBoard2[j + 2] == "r" && gameBoard2[j + 3] == "r"){
                    gameOver = true;
                    currentTurn = "Red";
                } else if(gameBoard2[j] == "b" && gameBoard2[j + 1] == "b" && gameBoard2[j + 2] == "b" && gameBoard2[j + 3] == "b"){
                    gameOver = true;
                    currentTurn = "Blue";
                }
            }
        }
    }

    public void checkDiagonals(){
        for(int i = 21; i < 36; i += 7){
            for(int j = i; j < i + 4; j++){
                if(gameBoard2[j] == "r" && gameBoard2[j - 6] == "r" && gameBoard2[j - 12] == "r" && gameBoard2[j - 18] == "r"){
                    gameOver = true;
                    currentTurn = "Red";
                } else if(gameBoard2[j] == "b" && gameBoard2[j - 6] == "b" && gameBoard2[j - 12] == "b" && gameBoard2[j - 18] == "b"){
                    gameOver = true;
                    currentTurn = "Blue";
                }
            }
        }
        for(int i = 27; i < 42; i += 7){
            for(int j = i; j > i - 4; j--){
                if(gameBoard2[j] == "r" && gameBoard2[j - 6] == "r" && gameBoard2[j - 12] == "r" && gameBoard2[j - 18] == "r"){
                    gameOver = true;
                    currentTurn = "Red";
                } else if(gameBoard2[j] == "b" && gameBoard2[j - 8] == "b" && gameBoard2[j - 16] == "b" && gameBoard2[j - 24] == "b"){
                    gameOver = true;
                    currentTurn = "Blue";
                }
            }
        }
    }
}