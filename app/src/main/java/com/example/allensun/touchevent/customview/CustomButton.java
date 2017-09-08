package com.example.allensun.touchevent.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by allensun on 9/8/17.
 * on Tubitv.com, allengotstuff@gmail.com
 */
public class CustomButton extends View {

    public static final String TAG = "TouchEvent";

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "CustomButton dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "CustomButton onTouchEvent");
        return super.onTouchEvent(event);
    }
}
