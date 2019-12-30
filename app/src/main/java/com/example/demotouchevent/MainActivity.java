package com.example.demotouchevent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] ARRAY = {
            "Test 1 MainActivity MainActivity MainActivity MainActivity",
            "Test 2 MainActivity MainActivity MainActivity MainActivity",
            "Test 3 MainActivity MainActivity MainActivity MainActivity",
            "Test 4 MainActivity MainActivity MainActivity MainActivity",
            "Test 5 MainActivity MainActivity MainActivity MainActivity",
            "Test 6 MainActivity MainActivity MainActivity MainActivity",
            "Test 7 MainActivity MainActivity MainActivity MainActivity",
            "Test 8 MainActivity MainActivity MainActivity MainActivity",
            "Test 9 MainActivity MainActivity MainActivity MainActivity",
            "Custom MainActivity MainActivity",
            "Touch MainActivity MainActivity MainActivity MainActivity",
            "Event MainActivity MainActivity"
    };
    private final List<String> LIST = Arrays.asList(ARRAY);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomConstraintLayout customConstraintLayout = findViewById(R.id.layout);
        CustomListView listView = findViewById(R.id.list_item);
        CustomAdapter adapter = new CustomAdapter(this);
        listView.setAdapter(adapter);

    }

    public final int ON_TOUCH_COLOR = 0xffff6363;
    public final int DISPATCH_COLOR = 0xff63ff63;
    public final int INTERCEPT_COLOR = 0xff6363ff;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Demo", "MainActivity onTouchEvent " + event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("Demo", "MainActivity dispatchTouchEvent " + event);
        return super.dispatchTouchEvent(event);
    }

    class CustomAdapter extends ArrayAdapter<String> {

        public CustomAdapter(@NonNull Context context) {
            super(context, R.layout.item, LIST);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            CustomTextView view = (CustomTextView) convertView;
            view = (CustomTextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
            view.setText(LIST.get(position));
            final View finalView = view;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finalView.setBackgroundColor(0x900090);
                }
            });
            return view;
        }
    }
}
