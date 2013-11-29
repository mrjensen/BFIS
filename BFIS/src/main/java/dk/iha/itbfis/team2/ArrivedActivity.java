package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

/**
 * Created by mje on 29/11/13.
 */
public class ArrivedActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrived);
        CountDownTimer countDownTimer = new CountDownTimer(1000, 5000) {
            int count = 0;
            @Override
            public void onTick(long l) {
                if (count == 0)
                    Toast.makeText(ArrivedActivity.this, "Gang fra bil til dør", Toast.LENGTH_LONG).show();
                count++;

            }

            @Override
            public void onFinish() {

                MediaPlayer mediaPlayer = MediaPlayer.create(ArrivedActivity.this, R.raw.beep);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Intent intent = new Intent(ArrivedActivity.this, PatientActivity.class);
                        startActivity(intent);
                        mediaPlayer.release();
                    }
                });
                mediaPlayer.start();


            }
        }.start();
    }
}