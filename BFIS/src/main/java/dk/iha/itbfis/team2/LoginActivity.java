package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mje on 22/11/13.
 */
public class LoginActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Context context = this;

        Button startButton = (Button) findViewById(R.id.btn_login);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ((EditText) findViewById(R.id.et_username)).getText().toString();
                String password = ((EditText) findViewById(R.id.et_password)).getText().toString();
                if (username.toLowerCase().equals("bente")  && password.equals("112")){
                    Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Brugernavn og password matcher ikke.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}