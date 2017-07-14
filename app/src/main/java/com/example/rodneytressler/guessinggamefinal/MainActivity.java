package com.example.rodneytressler.guessinggamefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

/** Java class for writing logic for app. */
public class MainActivity extends AppCompatActivity {

  private Button submitButton;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    /** This takes our submit button member variable above, and binds it to our
     * button UI element in our xml file. This works the same for each element.*/

    submitButton = (Button) findViewById(R.id.button_submit);
  }
}
