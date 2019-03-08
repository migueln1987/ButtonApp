package com.example.buttonapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    private static final long DOUBLE_PRESS_INTERVAL = 250;

    @BindView(R.id.red_button)
    ImageButton button;
    FrameLayout display;
    NumberFragment numberFrag;
    int counter = 0;
    private boolean doubleClick = false;
    private long lastPressTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        display = findViewById(R.id.display);
        numberFrag = new NumberFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.display, numberFrag).commit();
    }

    @OnClick(R.id.red_button)
    public void buttonPressed() {
        // TODO fix double click hack
        Log.d("buttonPressed", "Button is Pressed");
        detectDoubleClick();
        if(doubleClick) {
            this.counter += 4;
            this.counter -= 1;
            numberFrag.textView.setText(String.valueOf(counter));
        } else {
            this.counter++;
            numberFrag.setCounter(counter);
        }
       // numberFrag.textView.setText(String.valueOf(counter));

    }

    public void detectDoubleClick() {
        long pressTime = System.currentTimeMillis();
        if (pressTime - lastPressTime <= DOUBLE_PRESS_INTERVAL) {
            this.doubleClick = true;
        } else {
            this.doubleClick = false;
        }
        lastPressTime = pressTime;
    }

    @OnLongClick(R.id.red_button)
    public boolean longButtonPress() {
        this.counter = 0;
        numberFrag.textView.setText(String.valueOf(counter));
        return true;
    }
}
