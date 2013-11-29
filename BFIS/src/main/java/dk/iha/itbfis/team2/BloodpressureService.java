package dk.iha.itbfis.team2;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

/**
 * Created by kaspernissen on 29/11/13.
 */
public class BloodpressureService extends IntentService {

    public BloodpressureService(String name) {
        super(name);
    }

    public BloodpressureService() {
        super("BloodpressureService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        //Intent to input in the pending intent for starting the broadcastreceiver
        Intent broadcastIntent = new Intent(this, BloodpressureReceiver.class);

        //Put in the information passed from Alpha Activity.
        broadcastIntent.putExtras(intent.getExtras());

        //Create pending intent to use for activivating the broadcastreceiver.
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 123, broadcastIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        //Get the systetm alarm manager
        AlarmManager alarmManager = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);

        //Create calendar and set the alarmmanager.
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 5);
        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);


        Intent progressIntent = new Intent("dk.iha.itbfis.team2.sharing");


        while (true){

            sendBroadcast(progressIntent);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void onDestroy() {
        super.onDestroy();    //To change body of overridden methods use File | Settings | File Templates.
    }

}