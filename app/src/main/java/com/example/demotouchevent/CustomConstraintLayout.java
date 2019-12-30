package com.example.demotouchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomConstraintLayout extends ConstraintLayout {
    public CustomConstraintLayout(Context context) {
        super(context);
    }

    public CustomConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public final int ON_TOUCH_COLOR = 0xffff6363;
    public final int DISPATCH_COLOR = 0xff63ff63;
    public final int INTERCEPT_COLOR = 0xff6363ff;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        setBackgroundColor(ON_TOUCH_COLOR);
        Log.d("Demo","CustomConstraintLayout onTouchEvent " + event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        setBackgroundColor(DISPATCH_COLOR);
        Log.d("Demo","CustomConstraintLayout dispatchTouchEvent " + event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        setBackgroundColor(INTERCEPT_COLOR);
        Log.d("Demo","CustomConstraintLayout onInterceptTouchEvent " + ev);
        return super.onInterceptTouchEvent(ev);
    }
}
