package com.example.android.smartphonequiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int score;
    String savedScore, playerName, scoreMessage;
    private EditText questionThreeUserAnswer;
    private CheckBox questionOneChoiceOne, questionOneChoiceTwo, questionOneChoiceThree, questionOneChoiceFour,
            questionOneChoiceFive, questionOneChoiceSix, questionTenChoiceOne, questionTenChoiceTwo, questionTenChoiceThree;
    private RadioButton questionTwoChoiceThree, questiondFourChoiceOne, questionFiveChoiceTwo, questionSixChoiceOne,
            questionSevenChoiceThree, questionEightChoiceThree, questionNineChoiceOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.
                LayoutParams.FLAG_FULLSCREEN);
        questionOneChoiceOne = findViewById(R.id.question_1_choice_1);
        questionOneChoiceTwo = findViewById(R.id.question_1_choice_2);
        questionOneChoiceThree = findViewById(R.id.question_1_choice_3);
        questionOneChoiceFour = findViewById(R.id.question_1_choice_4);
        questionOneChoiceFive = findViewById(R.id.question_1_choice_5);
        questionOneChoiceSix = findViewById(R.id.question_1_choice_6);
        questionTwoChoiceThree = findViewById(R.id.question_2_choice_3);
        questionThreeUserAnswer = findViewById(R.id.question_3_edit_text);
        questiondFourChoiceOne = findViewById(R.id.question_4_choice_1);
        questionFiveChoiceTwo = findViewById(R.id.question_5_choice_2);
        questionSixChoiceOne = findViewById(R.id.question_6_choice_1);
        questionSevenChoiceThree = findViewById(R.id.question_7_choice_3);
        questionEightChoiceThree = findViewById(R.id.question_8_choice_3);
        questionNineChoiceOne = findViewById(R.id.question_9_choice_1);
        questionTenChoiceOne = findViewById(R.id.question_10_choice_1);
        questionTenChoiceTwo = findViewById(R.id.question_10_choice_2);
        questionTenChoiceThree = findViewById(R.id.question_10_choice_3);
        Intent getUserName = getIntent();
        playerName = getUserName.getStringExtra("NAME");
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(savedScore, score);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt(savedScore);
    }

    /**
     * The override that clears focus and hides keyboard on touch.
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent
                .ACTION_MOVE) && view instanceof EditText && !view.getClass().getName()
                .startsWith("android.webkit.")) {
            int screenCoordinates[] = new int[2];
            view.getLocationOnScreen(screenCoordinates);
            float x = ev.getRawX() + view.getLeft() - screenCoordinates[0];
            float y = ev.getRawY() + view.getTop() - screenCoordinates[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow((this.getWindow().getDecorView()
                                .getApplicationWindowToken()), 0);
            questionThreeUserAnswer.clearFocus();
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * This method is called to calculate the player's score based on the answers selected.
     */
    public void calculateScore(View view) {
        score = 0;

        /**
         * Checks if the wrong answers are checked and if the correct answers are checked for question 1.
         * If the correct answers are checked then it ads one point to the score.
         */
        if (questionOneChoiceTwo.isChecked() || questionOneChoiceFour.isChecked()) {
        } else if (questionOneChoiceOne.isChecked()) {
            if (questionOneChoiceThree.isChecked()) {
                if (questionOneChoiceFive.isChecked()) {
                    if (questionOneChoiceSix.isChecked()) {
                        score++;
                    }
                }
            }
        }

        /**
         * Checks if the correct answer is checked for question 2.
         * If the correct answer is checked then it ads one point to the score.
         */
        if (questionTwoChoiceThree.isChecked()) {
            score++;
        }

        /**
         * Checks if the correct answer is entered in the EditText from question 3.
         * If the correct answer is entered then it ads one point to the score.
         */
        String questionThreeAnswer = questionThreeUserAnswer.getText().toString();
        String questionThreeCorrectAnswer = getString(R.string.question_3_choice_1);
        if (questionThreeAnswer.equalsIgnoreCase(questionThreeCorrectAnswer)) {
            score++;
        }

        /**
         * Checks if the correct answer is checked for question 4.
         * If the correct answer is checked then it ads one point to the score.
         */
        if (questiondFourChoiceOne.isChecked()) {
            score++;
        }

        /**
         * Checks if the correct answer is checked for question 5.
         * If the correct answer is checked then it ads one point to the score.
         */
        if (questionFiveChoiceTwo.isChecked()) {
            score++;
        }

        /**
         * Checks if the correct answer is checked for question 6.
         * If the correct answer is checked then it ads one point to the score.
         */
        if (questionSixChoiceOne.isChecked()) {
            score++;
        }

        /**
         * Checks if the correct answer is checked for question 7.
         * If the correct answer is checked then it ads one point to the score.
         */
        if (questionSevenChoiceThree.isChecked()) {
            score++;
        }

        /**
         * Checks if the correct answer is checked for question 8.
         * If the correct answer is checked then it ads one point to the score.
         */
        if (questionEightChoiceThree.isChecked()) {
            score++;
        }

        /**
         * Checks if the correct answer is checked for question 9.
         * If the correct answer is checked then it ads one point to the score.
         */
        if (questionNineChoiceOne.isChecked()) {
            score++;
        }

        /**
         * Checks if the correct answers are checked for question 10.
         * If the correct answers are checked then it ads one point to the score.
         */
        if (questionTenChoiceOne.isChecked()) {
            if (questionTenChoiceTwo.isChecked()) {
                if (questionTenChoiceThree.isChecked()) {
                    score++;
                }
            }
        }

        /**
         * Creates a toast message containing the results, when the "Check results" button is clicked.
         */
        if (score == 1) {
            Toast.makeText(this, getString(R.string.one_point_score_toast, score), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.score_toast, score), Toast.LENGTH_SHORT).show();
        }

        /**
         * Creates the scoreMessage when the "Check results" button is clicked.
         */
        if (score == 10) {
            scoreMessage = getString(R.string.perfect_score_message, playerName, score);
        } else if (score >= 6 && score < 10) {
            scoreMessage = getString(R.string.average_score_message, playerName, score);
        } else if (score == 0) {
            scoreMessage = getString(R.string.no_score_message, playerName, score);
        } else {
            scoreMessage = getString(R.string.lame_score_message, playerName, score);
        }

        /**
         * Launches the "ResultsActivity" and sends the scoreMessage when the "Check results" button is clicked.
         */
        Intent startResultsActivity = new Intent(this, ResultsActivity.class);
        startResultsActivity.putExtra("SCOREMESSAGE", scoreMessage);
        if (startResultsActivity.resolveActivity(getPackageManager()) != null) {
            startActivity(startResultsActivity);
        }
    }
}