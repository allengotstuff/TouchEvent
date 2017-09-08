package com.example.allensun.touchevent.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by allensun on 9/8/17.
 * on Tubitv.com, allengotstuff@gmail.com
 */
public class CustomLinerlayout extends LinearLayout {

    public static final String TAG = "TouchEvent";

    public CustomLinerlayout(Context context) {
        super(context);
    }

    public CustomLinerlayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinerlayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "CustomLinerlayout onInterceptTouchEvent");
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "CustomLinerlayout dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "CustomLinerlayout onTouchEvent");
        return super.onTouchEvent(event);
    }
}
