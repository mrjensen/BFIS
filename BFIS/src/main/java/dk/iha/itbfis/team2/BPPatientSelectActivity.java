package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by kaspernissen on 29/11/13.
 */
public class BPPatientSelectActivity extends Activity {

    private Spinner dropdown;
    private Button btn_start;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btpatientselect);

        dropdown = (Spinner) findViewById(R.id.s_chooseperson);
        btn_start = (Button) findViewById(R.id.btn_startmeseaurement);

        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               String name = dropdown.getSelectedItem().toString();

                Intent intent = new Intent(BPPatientSelectActivity.this, BloodPressureActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }

        });
    }
}