package dk.iha.itbfis.team2;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.nfc.NfcAdapter;


public class ArrivedActivity extends Activity {
    protected NfcAdapter nfcAdapter;
    protected PendingIntent nfcPendingIntent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrived);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        nfcPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, this.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        enableForegroundMode();
    }

    @Override
    protected void onPause() {
        super.onPause();
        disableForegroundMode();
    }

    public void enableForegroundMode() {
        IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
        IntentFilter[] writeTagFilters = new IntentFilter[]{tagDetected};
        nfcAdapter.enableForegroundDispatch(this, nfcPendingIntent, writeTagFilters, null);
    }

    public void disableForegroundMode() {
        nfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
            //beepAndContinue();
            scanOk();
        }
    }

    public void scanOk() {
        Intent intent = new Intent(ArrivedActivity.this, PatientActivity.class);
        startActivity(intent);
    }

    public void beepAndContinue() {
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
}