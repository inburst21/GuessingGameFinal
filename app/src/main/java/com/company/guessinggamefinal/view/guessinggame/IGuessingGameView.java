package com.company.guessinggamefinal.view.guessinggame;

import com.company.guessinggamefinal.view.IGameView;

/**
 * lennyhicks
 * 12/8/17
 */

public interface IGuessingGameView extends IGameView {

    String getGuess();

    void goToWinningScreen(int generatedNumber);

    void setInstructions(String title);

    void setButtonText(String buttonText);

    void setInputText();
}
