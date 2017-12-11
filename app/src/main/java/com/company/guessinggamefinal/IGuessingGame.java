package com.company.guessinggamefinal;

import com.company.guessinggamefinal.view.guessinggame.IGuessingGameView;

/**
 * lennyhicks
 * 12/8/17
 */

abstract class IGuessingGame extends IGame<IGuessingGameView> {
    private int maxNumOfGuesses;
    private int generatedNumber;
    private int currentGuess;

    abstract void onGameButtonTapped();

    @Override
    void startGame() {
        setupGame();
    }

    @Override
    void setupGame() {
        maxNumOfGuesses = 5;
        generatedNumber = (int) Math.ceil(Math.random() * 100);
        currentGuess = 0;
    }

    int getGeneratedNumber() {
        return generatedNumber;
    }

    int getCurrentGuess() {
        return currentGuess;
    }

    int getMaxNumOfGuesses(){
        return maxNumOfGuesses;
    }

    void incrementGuess(){
        currentGuess++;
    }
}
