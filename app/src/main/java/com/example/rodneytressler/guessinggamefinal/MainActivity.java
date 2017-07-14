package com.example.rodneytressler.guessinggamefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/** Java class for writing logic for app. */
public class MainActivity extends AppCompatActivity {

  private Button submitButton;
  private EditText inputField;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /** This takes our submit button member variable above, and binds it to our
     * button UI element in our xml file. This works the same for each element.*/

    submitButton = (Button) findViewById(R.id.button_submit);

    /** This binds our edit text member variable to our edit text UI element from our XML file*/
    inputField = (EditText) findViewById(R.id.input_field);

    /** This method will listen for a button press on our submitButton*/
    submitButtonClicked();
  }

  private void submitButtonClicked() {

    /** Here we're setting an onClickListener on our button. afterwards, we can specify
     * what we wish to do when the button is clicked.*/

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {

        /** Here we're declaring a variable equal to the value inside of our edittext*/
        String inputText = inputField.getText().toString();

        /** Now we're toasting that value onto the screen!*/
        Toast.makeText(MainActivity.this, "Checking your guess of " + inputText, Toast.LENGTH_SHORT).show();
      }
    });
  }
}
