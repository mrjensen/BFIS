package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

/**
 * Created by kaspernissen on 29/11/13.
 */
public class PatientActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientinfo);

        CountDownTimer countDownTimer = new CountDownTimer(5000,5000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(PatientActivity.this, TodoActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}