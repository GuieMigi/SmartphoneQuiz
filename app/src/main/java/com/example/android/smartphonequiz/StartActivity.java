package com.example.android.smartphonequiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    public EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        name = findViewById(R.id.name_edit_text);
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
                        .hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
            name.clearFocus();
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * Launches the "ResultsActivity" and sends the playerName when the "Start quiz" button is clicked.
     */
    public void startQuiz(View view) {
        String playerName = name.getText().toString();
        if (name.length() == 0) {
            Toast.makeText(this, getString(R.string.enter_name_toast), Toast.LENGTH_LONG).show();
        } else {
            Intent startMainActivity = new Intent(this, MainActivity.class);
            startMainActivity.putExtra("NAME", playerName);
                startActivity(startMainActivity);
        }
    }
}
