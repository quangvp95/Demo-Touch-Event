package com.example.demotouchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public final int ON_TOUCH_COLOR = 0xffff6363;
    public final int DISPATCH_COLOR = 0xff63ff96;
    public final int INTERCEPT_COLOR = 0xff6363ff;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        setBackgroundColor(ON_TOUCH_COLOR);
        Log.d("Demo","CustomTextView onTouchEvent " + getText());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        setBackgroundColor(DISPATCH_COLOR);
        Log.d("Demo","CustomTextView dispatchTouchEvent " + getText());
        return super.dispatchTouchEvent(event);
    }
}
