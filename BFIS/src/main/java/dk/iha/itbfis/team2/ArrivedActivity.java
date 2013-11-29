package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by mje on 29/11/13.
 */
public class ArrivedActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrived);


        Toast.makeText(ArrivedActivity.this, "Gang fra bil til dør", Toast.LENGTH_LONG).show();

        Button btn_next = (Button) findViewById(R.id.btn_door_entry);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });

    }
}