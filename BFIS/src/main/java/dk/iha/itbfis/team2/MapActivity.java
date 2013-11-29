package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by kaspernissen on 29/11/13.
 */
public class MapActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        MediaPlayer mediaPlayer = MediaPlayer.create(MapActivity.this, R.raw.first_part);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
                MediaPlayer mediaPlayer2 = MediaPlayer.create(MapActivity.this, R.raw.second_part);
                mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                        Intent intent = new Intent(MapActivity.this, ArrivedActivity.class);
                        startActivity(intent);
                    }
                });
                mediaPlayer2.start();
            }
        });
        mediaPlayer.start();
    }
}