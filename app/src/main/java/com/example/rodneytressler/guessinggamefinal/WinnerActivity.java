package com.example.rodneytressler.guessinggamefinal;

/**
 * Created by rodneytressler on 7/14/17.
 */

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/** This will be our winner activity Java file, we have to extend AppCompatActivity*/
public class WinnerActivity extends AppCompatActivity{
  private Button restartButton;

  @Override public void onCreate(@Nullable Bundle savedInstanceState,
      @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);

    /** Here is where we'll set our xml file*/
    setContentView(R.layout.activity_winner);

    /** This binds our restart button member variable with our UI element restart button from our XML file*/
    restartButton = (Button) findViewById(R.id.button_restart);

    /** Now we've moved our restartButton and its call method and member variable to our new activity, we'll
     * have to give it different instructions than before.*/
    restartButtonClicked();
  }

  public void restartButtonClicked() {
    /** Now we'll set an onClickListener for our restart button and have it call our startGame() method
     * to start the game over and to set the visibility of our restart button back to gone.*/

    restartButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(WinnerActivity.this, "Restarting Game", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
