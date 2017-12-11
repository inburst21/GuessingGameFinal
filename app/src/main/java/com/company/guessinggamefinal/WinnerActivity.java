package com.company.guessinggamefinal;

/**
 * Created by rodneytressler on 7/14/17.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodneytressler.guessinggamefinal.R;


/** This will be our winner activity Java file, we have to extend AppCompatActivity*/
public class WinnerActivity extends AppCompatActivity {
  private Button restartButton;
  private TextView winningMessage;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    /** Here is where we'll set our xml file*/
    setContentView(R.layout.activity_winner);

    /** This binds our restart button member variable with our UI element restart button from our XML file*/
    restartButton = (Button) findViewById(R.id.button_restart);

    /** Now we've moved our restartButton and its call method and member variable to our new activity, we'll
     * have to give it different instructions than before.*/
    restartButtonClicked();

    /** This method will retrieve the winning number to set our textview equal to the value of the winning number.
     * but first we must create an id for our textview and bind it to our member variable*/
    winningMessage = (TextView) findViewById(R.id.winning_message);
    showWinningNumber();
  }

  public void restartButtonClicked() {
    /** Now we'll set an onClickListener for our restart button and have it call our startGame() method
     * to start the game over and to set the visibility of our restart button back to gone.*/

    restartButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(WinnerActivity.this, "Restarting Game", Toast.LENGTH_SHORT).show();
        finish();
      }
    });
  }

  /** This method listens for the winning int extra sent from our main activity, retrieves it,
   * then sets our textview equal to that amount.*/
  public void showWinningNumber() {
    Intent intent = getIntent();
    int winningNumber = intent.getIntExtra(MainActivity.WINNING_NUMBER, 0);
    winningMessage.setText("You won! The winning value was " + String.valueOf(winningNumber) + "!");
  }
}
