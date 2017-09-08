package com.example.allensun.touchevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TouchEvent";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.e(TAG, "Activity dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.e(TAG, "Activity onTouchEvent");
        return super.onTouchEvent(event);
    }
}
