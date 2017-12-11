package com.company.guessinggamefinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.company.guessinggamefinal.view.guessinggame.IGuessingGameView;
import com.example.rodneytressler.guessinggamefinal.R;

/**
 * Java class for writing logic for app.
 */
public class MainActivity extends AppCompatActivity implements IGuessingGameView {

    public static final String WINNING_NUMBER = "WINNING_NUMBER";

    private Button gameButton;
    private EditText inputField;
    private TextView instructions;

    IGuessingGame guessingGame = new GuessingGame();


    /**
     * This is a member variable for our winning number
     */
    @SuppressWarnings("uncase")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** This takes our submit button member variable above, and binds it to our
         * button UI element in our xml file. This works the same for each element.*/

        gameButton = findViewById(R.id.button_submit);

        /** This binds our edit text member variable to our edit text UI element from our XML file*/
        inputField = findViewById(R.id.input_field);

        /** This binds our text view to our textview UI element from our XML file*/
        instructions = findViewById(R.id.instructions);

        guessingGame.setView(this);


        /** This method will listen for a button press on our gameButton*/
        startButtonListener();

    }


    private void startButtonListener() {

        /** Here we're setting an onClickListener on our button. afterwards, we can specify
         * what we wish to do when the button is clicked. We make our functionality based on the button's text, as we want it to do something
         * completely differently if the text says 'restart' after running out of turns and losing. */

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guessingGame.onGameButtonTapped();
            }
        });
    }


    @Override
    public void setInstructions(String text) {
        instructions.setText(text);
    }

    @Override
    public void setButtonText(String buttonText) {
        gameButton.setText(buttonText);
    }

    @Override
    public void setInputText() {
        inputField.setText("");
    }

    @Override
    public void goToWinningScreen(int generatedNumber) {
        Intent intent = new Intent(this, WinnerActivity.class);

        /** This is where we'll pass the winning number into the winning activity, so it can set the textview equal to
         * the winning value*/
        intent.putExtra(WINNING_NUMBER, generatedNumber);
        startActivity(intent);
    }

    @Override
    public String getGuess() {
        return inputField.getText().toString();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
