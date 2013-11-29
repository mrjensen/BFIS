package dk.iha.itbfis.team2;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by kaspersaaby on 22/11/13.
 */
public class TodoActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
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