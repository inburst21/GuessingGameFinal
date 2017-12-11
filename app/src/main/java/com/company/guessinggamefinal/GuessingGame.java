package com.company.guessinggamefinal;

/**
 * lennyhicks
 * 12/8/17
 */

class GuessingGame extends IGuessingGame  {

    private String STRING_HIGHER = "Higher";
    private String STRING_LOWER = "Lower";
    private String STRING_TURNS_LEFT = getMaxNumOfGuesses() - getCurrentGuess() + " turn(s) left!";
    private String STRING_DEFAULT_INFO = "Please enter a number between 1-100";
    private String STRING_OUT_OF_GUESSES = "Out of Guesses";
    private String STRING_RESET = "Reset";
    private String STRING_GUESS = "Guess";

    @Override
    void onGameButtonTapped() {
        if(getCurrentGuess() < getMaxNumOfGuesses()) {
            checkGuess();
        } else {
            startGame();
        }
    }

    @Override
    void startGame() {
        super.setupGame();
        getGameView().setInputText();
        getGameView().setButtonText(STRING_GUESS);
        getGameView().setInstructions(STRING_DEFAULT_INFO);
    }

    private void checkGuess() {
        try {
            Integer guess = Integer.valueOf(getGameView().getGuess());

            if (guess != null) {
                incrementGuess();

                if (guess == getGeneratedNumber()) {

                    getGameView().goToWinningScreen(getGeneratedNumber());
                    return;

                } else if (guess > getGeneratedNumber()){
                    getGameView().setInstructions(STRING_LOWER);

                } else {
                    getGameView().setInstructions(STRING_HIGHER);
                }

                showMessage(STRING_TURNS_LEFT);
            }
        } catch (NumberFormatException n){
            showMessage(STRING_DEFAULT_INFO);
        }
        if (getCurrentGuess() == getMaxNumOfGuesses()){
            endGame();
        }
    }

    private void endGame(){
        getGameView().setInstructions(STRING_OUT_OF_GUESSES);
        getGameView().setButtonText(STRING_RESET);
        getGameView().setInputText();
    }
}
