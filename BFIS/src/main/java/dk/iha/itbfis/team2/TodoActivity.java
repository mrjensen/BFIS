package dk.iha.itbfis.team2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kaspersaaby on 22/11/13.
 */
public class TodoActivity extends Activity {

    private boolean setDone = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        Intent intent = getIntent();
        if (intent.getExtras() != null)
            setDone = intent.getExtras().getBoolean("setDone");

        int[] ids = new int [] {R.id.todo_btn_1, R.id.todo_btn_2, R.id.todo_btn_3, R.id.todo_btn_4};
        Button btn = null;

        if (setDone) {
            for(int i = 0; i < ids.length; i++) {
                btn = (Button)findViewById(ids[i]);
                btn.setBackground(new ColorDrawable(Color.GREEN));
            }
        } else {
            for(int i = 0; i < ids.length; i++) {
                btn = (Button)findViewById(ids[i]);
                btn.setBackground(new ColorDrawable(Color.YELLOW));
            }
        }

        if (!setDone) {
            new CountDownTimer(20000, 1000) {
                @Override
                public void onTick(long l) {
                    TextView textView = (TextView)findViewById(R.id.tick);
                    textView.setText("" + l);
                }

                @Override
                public void onFinish() {
                    Intent intent = new Intent(TodoActivity.this, BPPatientSelectActivity.class);
                    startActivity(intent);
                }
            }.start();
        }
    }

    public void taskCompleted(View view) {
        int btnId = view.getId();
        Button btn = null;

        switch(btnId) {
            case R.id.todo_btn_1:
                btn = (Button)findViewById(R.id.todo_btn_1);
                setColor(btn);
                break;
            case R.id.todo_btn_2:
                btn = (Button)findViewById(R.id.todo_btn_2);
                setColor(btn);
                break;
            case R.id.todo_btn_3:
                btn = (Button)findViewById(R.id.todo_btn_3);
                setColor(btn);
                break;
            case R.id.todo_btn_4:
                btn = (Button)findViewById(R.id.todo_btn_4);
                setColor(btn);
                break;
        }
    }

    private void setColor(Button button) {
        ColorDrawable drawable = (ColorDrawable)button.getBackground();
        int currentColor = drawable.getColor();
        int newColor;

        if (currentColor == Color.YELLOW)
            newColor = Color.GREEN;
        else
            newColor = Color.YELLOW;

        button.setBackground(new ColorDrawable(newColor));
    }
}