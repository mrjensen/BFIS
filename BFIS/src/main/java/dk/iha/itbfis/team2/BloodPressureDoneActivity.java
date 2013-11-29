package dk.iha.itbfis.team2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by kaspernissen on 29/11/13.
 */
public class BloodPressureDoneActivity extends Activity {

    private TextView tv_name;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodpressuredone);

        tv_name = (TextView) findViewById(R.id.tv_patientdone);
        tv_name.setText(getIntent().getExtras().getString("name"));
    }
}