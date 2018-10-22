package nyc.tanjim.mathtank;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class Scores extends AppCompatActivity {

    private TextView aScore, tScore, qScore;
    private TextView advancedScore, quickMathScore, timeTrialsScore;
    private TextView timesPlayed, timeTaken, aTimeTaken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean darkModePref = sharedPref.getBoolean(SettingsActivity.KEY_DARK_MODE_SWITCH, false);


        aScore = findViewById(R.id.aScore);
        tScore = findViewById(R.id.tScore);
        qScore = findViewById(R.id.qScore);
        advancedScore = findViewById(R.id.advancedScore);
        quickMathScore = findViewById(R.id.quickMathHigh);
        timeTrialsScore = findViewById(R.id.timeTrialsScore);
        timesPlayed = findViewById(R.id.timesPlayed);
        timeTaken = findViewById(R.id.timeTaken);
        aTimeTaken = findViewById(R.id.aTimeTaken);
        SharedPreferences preferences = getSharedPreferences("highScore",MODE_PRIVATE);
        int quickTimeHighScore = preferences.getInt("quickMathHighScore",0);
        int quickTimeHighScoreTotal = preferences.getInt("quickMathHighScoreWrong",0);
        int timesPlayedText = preferences.getInt("timesPlayed",0);
        int timeTrialsHighScore = preferences.getInt("timeTrialsHighScore",0);
        int advancedHighScore = preferences.getInt("advancedHighScore",0);
        int advancedHighScoreTotal = preferences.getInt("advancedHighScoreTotal",0);
        String advancedTimeTaken = preferences.getString("advancedTimeTaken","00:00");
        String timeTrialsTimeTaken = preferences.getString("timeTaken","00:00");
        qScore.setText(getString(R.string.qScore,quickTimeHighScore,quickTimeHighScoreTotal));
        timesPlayed.setText(getString(R.string.timesPlayed,timesPlayedText));
        tScore.setText(getString(R.string.tScore,timeTrialsHighScore));
        timeTaken.setText(getString(R.string.timeTaken,timeTrialsTimeTaken));
        aScore.setText(getString(R.string.aScore,advancedHighScore,advancedHighScoreTotal));
        aTimeTaken.setText(getString(R.string.aTimeTaken,advancedTimeTaken));

        if(darkModePref){
            ScrollView scrollView = (findViewById(R.id.scoresBg));
            scrollView.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.color.qboard_black));
            qScore.setBackground(getDrawable(R.drawable.main_menu_button_bg_dk));
            quickMathScore.setBackground(getDrawable(R.drawable.main_menu_button_bg_dk));
            timesPlayed.setBackground(getDrawable(R.drawable.main_menu_button_bg_dk));
            tScore.setBackground(getDrawable(R.drawable.main_menu_button_og_dk));
            timeTrialsScore.setBackground(getDrawable(R.drawable.main_menu_button_og_dk));
            timeTaken.setBackground(getDrawable(R.drawable.main_menu_button_og_dk));
            aScore.setBackground(getDrawable(R.drawable.main_menu_button_rd_dk));
            advancedScore.setBackground(getDrawable(R.drawable.main_menu_button_rd_dk));
            aTimeTaken.setBackground(getDrawable(R.drawable.main_menu_button_rd_dk));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.qboard_black));
            }
        }
    }

}
