package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mje on 22/11/13.
 */
public class LoginActivity extends Activity {

    private EditText et_username;
    private EditText et_password;
    private LinearLayout layout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Context context = this;
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        layout = (LinearLayout) findViewById(R.id.ll_login);

        et_username.requestFocus();

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

        layout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if (b && (et_username.getText().length() > 0) && (et_password.getText().length() > 0)){
                    layout.requestFocus();
                    InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                else if (b && (et_username.getText().length() > 0)){
                    et_password.requestFocus();
                }
                else if (b){
                    layout.requestFocus();
                    InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Nothing is everything
            }
        });
        et_password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                enter();
                return false;
            }
        });

        Button startButton = (Button) findViewById(R.id.btn_login);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enter();
            }
        });

    }



    private void enter(){
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        if (username.toLowerCase().contains("bente")  && password.contains("112")){
            Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Brugernavn og password matcher ikke.", Toast.LENGTH_SHORT).show();
        }
    }


}