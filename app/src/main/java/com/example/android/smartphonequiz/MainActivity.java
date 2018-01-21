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

    /**
     * The total score of the user based on the answers selected.
     */
    int score;
    String savedScore;
    EditText name;
    EditText questionThreeUserAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        name = findViewById(R.id.name_edit_text);
        questionThreeUserAnswer = findViewById(R.id.question_3_edit_text);
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
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
            name.clearFocus();
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
         * The EditText where the player enters his/her name.
         */
        String playerName = name.getText().toString();
        /**
         * Question 1 CheckBoxes.
         */
        CheckBox questionOneChoiceOne = findViewById(R.id.question_1_choice_1);
        CheckBox questionOneChoiceTwo = findViewById(R.id.question_1_choice_2);
        CheckBox questionOneChoiceThree = findViewById(R.id.question_1_choice_3);
        CheckBox questionOneChoiceFour = findViewById(R.id.question_1_choice_4);
        CheckBox questionOneChoiceFive = findViewById(R.id.question_1_choice_5);
        CheckBox questionOneChoiceSix = findViewById(R.id.question_1_choice_6);

        /**
         * Checks if the wrong answers are checked and if the correct answers are checked for question 1.
         * If the correct answers are checked then it ads one point to the score.
         */
        if (questionOneChoiceTwo.isChecked() || questionOneChoiceFour.isChecked()) {
        } else if (questionOneChoiceOne.isChecked()) {
            if (questionOneChoiceThree.isChecked()) {
                if (questionOneChoiceFive.isChecked()) {
                    if (questionOneChoiceSix.isChecked()) {
                        score += 1;
                    }
                }
            }
        }

        /**
         * Checks if the correct answer is checked for question 2.
         * If the correct answer is checked then it ads one point to the score.
         */
        RadioButton questionTwoChoiceThree = findViewById(R.id.question_2_choice_3);
        if (questionTwoChoiceThree.isChecked()) {
            score += 1;
        }

        /**
         * Checks if the correct name is entered in the EditText.
         * If the correct name is entered then it ads one point to the score.
         */
        String questionThreeAnswer = questionThreeUserAnswer.getText().toString();
        String questionThreeCorrectAnswer = getString(R.string.question_3_choice_1);
        if (questionThreeAnswer.equalsIgnoreCase(questionThreeCorrectAnswer)) {
            score += 1;
        }

        /**
         * Checks if the correct answer is checked for question 4.
         * If the correct answer is checked then it ads one point to the score.
         */
        RadioButton questiondFourChoiceOne = findViewById(R.id.question_4_choice_1);
        if (questiondFourChoiceOne.isChecked()) {
            score += 1;
        }

        /**
         * Checks if the correct answer is checked for question 5.
         * If the correct answer is checked then it ads one point to the score.
         */
        RadioButton questionFiveChoiceTwo = findViewById(R.id.question_5_choice_2);
        if (questionFiveChoiceTwo.isChecked()) {
            score += 1;
        }

        /**
         * Checks if the correct answer is checked for question 6.
         * If the correct answer is checked then it ads one point to the score.
         */
        RadioButton questionSixChoiceOne = findViewById(R.id.question_6_choice_1);
        if (questionSixChoiceOne.isChecked()) {
            score += 1;
        }

        /**
         * Checks if the correct answer is checked for question 7.
         * If the correct answer is checked then it ads one point to the score.
         */
        RadioButton questionSevenChoiceThree = findViewById(R.id.question_7_choice_3);
        if (questionSevenChoiceThree.isChecked()) {
            score += 1;
        }

        /**
         * Checks if the correct answer is checked for question 8.
         * If the correct answer is checked then it ads one point to the score.
         */
        RadioButton questionEightChoiceThree = findViewById(R.id.question_8_choice_3);
        if (questionEightChoiceThree.isChecked()) {
            score += 1;
        }

        /**
         * Checks if the correct answer is checked for question 9.
         * If the correct answer is checked then it ads one point to the score.
         */
        RadioButton questionNineChoiceOne = findViewById(R.id.question_9_choice_1);
        if (questionNineChoiceOne.isChecked()) {
            score += 1;
        }

        /**
         * Question 10 CheckBoxes.
         */
        CheckBox questionTenChoiceOne = findViewById(R.id.question_10_choice_1);
        CheckBox questionTenChoiceTwo = findViewById(R.id.question_10_choice_2);
        CheckBox questionTenChoiceThree = findViewById(R.id.question_10_choice_3);

        /**
         * Checks if the correct answers are checked for question 10.
         * If the correct answers are checked then it ads one point to the score.
         */
        if (questionTenChoiceOne.isChecked()) {
            if (questionTenChoiceTwo.isChecked()) {
                if (questionTenChoiceThree.isChecked()) {
                    score += 1;
                }
            }
        }

        /**
         * Creates a toast message containing the results, when the "Check results" button is clicked.
         */
        if (score == 10) {
            Toast.makeText(this, getString(R.string.perfect_score_toast, playerName, score), Toast.LENGTH_LONG).show();
        } else if (score >= 6 && score < 10) {
            Toast.makeText(this, getString(R.string.average_score_toast, playerName, score), Toast.LENGTH_LONG).show();
        } else if (score == 0) {
            Toast.makeText(this, getString(R.string.no_score_toast, playerName, score), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.lame_score_toast, playerName, score), Toast.LENGTH_LONG).show();
        }
    }

    public void restartQuiz(View view) {
        Intent MainActivity = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        MainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(MainActivity);
    }
}