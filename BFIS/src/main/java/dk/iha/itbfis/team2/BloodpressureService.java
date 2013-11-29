package dk.iha.itbfis.team2;

import android.app.Activity;
import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;

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