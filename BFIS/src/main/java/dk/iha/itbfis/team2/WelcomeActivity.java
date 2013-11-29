package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

/**
 * Created by mje on 22/11/13.
 */
public class WelcomeActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        CountDownTimer countDownTimer = new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this, MapActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}