package dk.iha.itbfis.team2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by kaspernissen on 29/11/13.
 */
public class BloodpressureReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String message = intent.getExtras().getString("textToBravo");

        Intent progressIntent = new Intent("iha.dk.smap.Smap02.sharingIntent");
        progressIntent.putExtra("secondsLeft", 0);

        context.sendBroadcast(progressIntent);

        Intent new_intent = new Intent(context,BloodPressureDoneActivity.class);
        new_intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        new_intent.putExtras(intent.getExtras());
        context.startActivity(new_intent);
    }
}
