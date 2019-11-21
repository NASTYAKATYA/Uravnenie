package ru.samsung.itschool.book.equation243;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    // Вызывается при создании Активности 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Инициализирует Активность.
        setContentView(R.layout.activity_main);
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
    public void solveEquation(View view) {
// ax+b=c
        double a = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_a)).getText().toString());
        double b = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_b)).getText().toString());
        double c = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_c)).getText().toString());
        TextView result = (TextView) findViewById(R.id.result);
        double d=b*b-4*a*c;
        if (a != 0) {
            if (b != 0 && c != 0) {
                if (d > 0) {
                    result.setText("" + String.valueOf((-b + Math.sqrt(d)) / (2 * a))+" " + String.valueOf((-b - Math.sqrt(d)) / (2 * a)) );
                }
                else if (d == 0) {
                    result.setText("" + String.valueOf( -b / (2 * a)));
                }
                else if (d < 0) {
                    result.setText("No solution" );
                }
            }
            else if (b == 0) {
                if (-c / a < 0) {
                    result.setText("error");
                }
                else if (-c / a >= 0) {
                    result.setText("" + String.valueOf(-b + Math. sqrt(-c / a))+" " + String.valueOf(-b - Math. sqrt(-c / a)));
                }
            }
            else if (c == 0) {
                result.setText("" + String.valueOf( -b / a));
                result.setText("0");
            }
        }
        else if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    result.setText("inf solution" );
                }
                else if (c != 0) {
                    result.setText("No solution");
                }
            }
            else if (b != 0) {
                if (c != 0) {
                    result.setText("" + String.valueOf( (-c / b)));
                }
                else if (c == 0) {
                    result.setText("0" );
                }
            }
        }
    }

}
