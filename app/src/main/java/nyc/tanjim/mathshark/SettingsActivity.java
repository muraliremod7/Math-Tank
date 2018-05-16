package nyc.tanjim.mathshark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {
    public static final String KEY_DARK_MODE_SWITCH = "dark_mode_switch";
    public static final String KEY_ADDITION_ONLY_QUICKMATH = "addition_only_quickmath";
    public static final String KEY_SUBTRACTION_ONLY_QUICKMATH = "subtraction_only_quickmath";
    public static final String KEY_MULTIPLICATION_ONLY_QUICKMATH = "multiplication_only_quickmath";
    public static final String KEY_DIVISION_ONLY_QUICKMATH = "division_only_quickmath";
    public static final String KEY_TIMER = "timer_quick_math";
    public static final String KEY_ADDITION_ADVANCED ="addition_advanced";
    public static final String KEY_SUBTRACTION_ADVANCED ="subtraction_advanced";
    public static final String KEY_ADDITION_X_MULTIPLICATION ="addition_x_multiplication";
    public static final String KEY_SUBTRACTION_X_MULTIPLICATION ="subtraction_x_multiplication";
    public static final String KEY_SUBTRACTION_BY_DIVISION ="subtraction_by_division";
    public static final String KEY_ADDITION_BY_DIVISION ="addition_by_division";
    public static final String KEY_SQUARE_ROOT="sqrt";
    public static final String KEY_SQUARE="sqr";
    public static final String KEY_CUBE="cube";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
