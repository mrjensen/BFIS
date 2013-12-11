package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by kaspernissen on 22/11/13.
 */
public class BloodPressureActivity extends Activity {

    private TextView max;
    private TextView min;
    private TextView patient;
    private TextView puls;
    private ImageView heart;
    boolean toogle = false;

    private class TickReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Random rand=new Random();
            Random rand1= new Random();
            Random rand2 = new Random();
            int maxP = (rand.nextInt(150-120) + 120);
            int minP = (rand1.nextInt(80-70) + 70);
            int pulse = (rand2.nextInt(99-80) + 80);

            max.setText(Integer.toString(maxP));
            min.setText(Integer.toString(minP));
            puls.setText(Integer.toString(pulse));


            if(toogle)
            {
                heart.setImageResource(R.drawable.heart);
                toogle = false;
            }
            else{
                heart.setImageResource(R.drawable.heart_light);
                toogle = true;
            }
        }
    }

    private TickReceiver tickReceiver = new TickReceiver();
    private Intent intent;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodpressure);

        String name = getIntent().getExtras().getString("name");

        max = (TextView) findViewById(R.id.tv_max_puls);
        min = (TextView) findViewById(R.id.tv_min_puls);
        puls = (TextView) findViewById(R.id.tv_puls);
        heart = (ImageView) findViewById(R.id.iv_heart);
        patient = (TextView) findViewById(R.id.tv_patient);

        patient.setText(name);

        intent = new Intent(BloodPressureActivity.this, BloodpressureService.class);
        intent.putExtra("name", name);

        startService(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Unregister when the application is paused.
        unregisterReceiver(tickReceiver);
        this.stopService(intent);

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Register the tick receiver, when resuming.
        registerReceiver(tickReceiver, new IntentFilter("dk.iha.itbfis.team2.sharing"));
    }

}
