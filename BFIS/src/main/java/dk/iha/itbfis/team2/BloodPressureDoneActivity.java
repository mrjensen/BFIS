package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kaspernissen on 29/11/13.
 */
public class BloodPressureDoneActivity extends Activity {

    private TextView tv_name;
    private Button btn_save;
    private Button btn_cancel;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodpressuredone);

        tv_name = (TextView) findViewById(R.id.tv_patientdone);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_save = (Button) findViewById(R.id.btn_save);
        tv_name.setText(getIntent().getExtras().getString("name"));


        btn_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BloodPressureDoneActivity.this, BPPatientSelectActivity.class);
                startActivity(intent);
            }

        });

        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }

        });

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(BloodPressureDoneActivity.this, TodoActivity.class);
                intent.putExtra("setDone", true);
                startActivity(intent);
            }
        }.start();
    }
}