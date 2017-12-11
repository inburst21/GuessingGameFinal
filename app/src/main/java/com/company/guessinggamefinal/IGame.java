package com.company.guessinggamefinal;

import android.util.Log;

import com.company.guessinggamefinal.view.IGameView;


/**
 * lennyhicks
 * 12/8/17
 */

abstract class IGame<T extends IGameView> {

    private T gameView;

    abstract void startGame();

    abstract void setupGame();

    void setView(T gameView) {
        if (setGameView(gameView)) {
            startGame();
        }
    }

    void showMessage(String message) {
        debug(message);
        getGameView().showMessage(message);
    }

    T getGameView() {
        return gameView;
    }

    private boolean setGameView(T gameView) {
        if (gameView != null) {
            this.gameView = gameView;
            showMessage("Game View Init");
            return true;
        } else {
            showMessage("Error");
        }
        return false;
    }

    private void debug(String debugMessage) {
        Log.i(getGameView().getClass().getSimpleName(), " [ DEBUG ] - " + debugMessage);
    }
}
