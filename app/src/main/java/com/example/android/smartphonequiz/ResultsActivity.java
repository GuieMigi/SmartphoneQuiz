package com.example.android.smartphonequiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    String scoreMessage;
    TextView resultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent getScoreMessage = getIntent();
        scoreMessage = getScoreMessage.getStringExtra("SCOREMESSAGE");
        resultsTextView = findViewById(R.id.results_text_view);
        resultsTextView.setText(scoreMessage);
    }

    /**
     * This method launches an email app to share the results when the "Share results" button is clicked.
     */
    public void shareResults(View view) {
        Intent sharedResults = new Intent(Intent.ACTION_SENDTO);
        sharedResults.setType("*/*");
        sharedResults.setData(Uri.parse("mailto:"));
        sharedResults.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_results_message_subject));
        sharedResults.putExtra(Intent.EXTRA_TEXT, scoreMessage);
        if (sharedResults.resolveActivity(getPackageManager()) != null) {
            startActivity(sharedResults);
        }
    }

    /**
     * This method restart the quiz when the "Restart Quiz" button is clicked.
     */
    public void restartQuiz(View view) {
        Intent MainActivity = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        MainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(MainActivity);
    }
}
