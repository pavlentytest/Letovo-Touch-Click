package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private Button btn1, btn2, btn3;
    private Switch aSwitch;
    private float x, y;
    private TextView tv;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.root);
        constraintLayout.setOnTouchListener(this);
        tv = findViewById(R.id.textView);

        btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        aSwitch = findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("RRRRR",Boolean.toString(b));
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            Snackbar.make(findViewById(R.id.root), R.string.message, Snackbar.LENGTH_LONG).show();
        } else {
            ConstraintLayout cr = findViewById(R.id.root);
            cr.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        x = motionEvent.getX();
        y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                tv.setText("Down: x="+x+"; y="+y );
                break;
            case MotionEvent.ACTION_MOVE:
                tv.setText("Move: x="+x+"; y="+y );
                break;
            case MotionEvent.ACTION_UP:
                tv.setText("Up: x="+x+"; y="+y );
                break;
        }
        return true;
    }


  /*  @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }

   */
}