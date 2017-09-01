package com.example.rodneytressler.guessinggamefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.ThreadLocalRandom;

/** Java class for writing logic for app. */
public class MainActivity extends AppCompatActivity {

  public static final String WINNING_NUMBER = "WINNING_NUMBER";

  private Button submitButton;
  private EditText inputField;
  private TextView instructions;
  private int turnsLeft;


  /** This is a member variable for our winning number*/
  private int winningNumber;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /** This takes our submit button member variable above, and binds it to our
     * button UI element in our xml file. This works the same for each element.*/

    submitButton = (Button) findViewById(R.id.button_submit);

    /** This binds our edit text member variable to our edit text UI element from our XML file*/
    inputField = (EditText) findViewById(R.id.input_field);

    /** This binds our text view to our textview UI element from our XML file*/
    instructions = (TextView) findViewById(R.id.instructions);


    /** This method will listen for a button press on our submitButton*/
    submitButtonClicked();

    /** This method will start the game and set up all of the views for the app, along with the winning number*/
    startGame();

  }

  private void startGame() {
    /** Here we generate a random winning number between the range of 1 and 100. We add 1 to the winning
     * value to make sure it can reach 100. */

    turnsLeft = 5;
    winningNumber = 1 + (int)(Math.random() * ((100 - 1) + 1));

    /** Here we're using our previously extracted String resource for instructions to set the text when starting
     * a game to the instructions*/

    instructions.setText(getResources().getString(R.string.instructions));

    /** This will set the input text value to blank, in case the player is restarting the game*/
    inputField.setText("");

  }

  private void submitButtonClicked() {

    /** Here we're setting an onClickListener on our button. afterwards, we can specify
     * what we wish to do when the button is clicked. We make our functionality based on the button's text, as we want it to do something
     * completely differently if the text says 'restart' after running out of turns and losing. */

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if (!submitButton.getText().equals("Restart")) {

          /** Here we're declaring a variable equal to the value inside of our edittext*/
          String inputText = inputField.getText().toString();


          /** Now we'll pass our guess into our checkGuess method, to see if we won. We first have to convert our
           * string guess into an int so its value can be checked. We do this with Integer.parseInt()*/
          checkGuess(Integer.parseInt(inputText));

          /** This will erase all of the text in our edittext box*/
          inputField.setText("");
        } else {
          submitButton.setText("Submit");
          startGame();
        }
      }
    });
  }

  public void checkGuess(int guess) {

    /** This checks our guess and sets the instructional text view accordingly. It decrements the amount of turns the user has left and
     * changes the text and button text when they run out of turns, which, as we know, changes the functionality of the button.*/

    if (turnsLeft != 1) {
      turnsLeft--;
      if (guess > winningNumber) {
        instructions.setText("Lower");
        Toast.makeText(this, turnsLeft + " turn(s) left!", Toast.LENGTH_SHORT).show();
      } else if (guess < winningNumber) {
        instructions.setText("Higher");
        Toast.makeText(this, turnsLeft + " turn(s) left!", Toast.LENGTH_SHORT).show();
      } else if (guess == winningNumber) {
        /** Here we're creating our intent. this forms a relationship, a connection between these
         * two activities. We're calling startGame() to reset all values, in case we want
         * to play again, as the activity is still running when it's not visible*/
        Intent intent = new Intent(this, WinnerActivity.class);

        /** This is where we'll pass the winning number into the winning activity, so it can set the textview equal to
         * the winning value*/
        intent.putExtra(WINNING_NUMBER, winningNumber);
        startActivity(intent);
        startGame();
      } else {
        Toast.makeText(this, "Invalid Entry, please try again!", Toast.LENGTH_SHORT).show();
      }
    } else {
      instructions.setText("Game Over! The winning number was " + winningNumber + ". Please try again.");
      submitButton.setText("Restart");
    }
  }

}
